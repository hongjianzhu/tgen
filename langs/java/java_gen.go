package java

import (
	"bytes"
	"fmt"
	"log"
	"os"
	"path/filepath"
	"strings"
	"text/template"

	"github.com/ezbuy/tgen/global"
	"github.com/ezbuy/tgen/langs"
	"github.com/ezbuy/tgen/tmpl"
	"github.com/samuel/go-thrift/parser"
)

const (
	javaLang = "java"
	javaExt  = ".java"
)

const (
	JavaTypeshort  = "short"
	JavaTypeint    = "int"
	JavaTypelong   = "long"
	JavaTypebool   = "boolean"
	JavaTypebyte   = "byte"
	JavaTypedouble = "double"

	JavaTypeString = "String"

	JavaTypeShort  = "Short"
	JavaTypeInt    = "Integer"
	JavaTypeLong   = "Long"
	JavaTypeBool   = "Boolean"
	JavaTypeByte   = "Byte"
	JavaTypeDouble = "Double"

	// other types (such as array, map, etc.) are implemented in the method 'Typecast'
)

const (
	TPL_ENUM    = "tgen/java/enum"
	TPL_STRUCT  = "tgen/java/struct"
	TPL_SERVICE = "tgen/java/service"
)

var plaintypemapping = map[string]string{
	langs.ThriftTypeI16:    JavaTypeshort,
	langs.ThriftTypeI32:    JavaTypeint,
	langs.ThriftTypeI64:    JavaTypelong,
	langs.ThriftTypeString: JavaTypeString,
	langs.ThriftTypeByte:   JavaTypebyte,
	langs.ThriftTypeBool:   JavaTypebool,
	langs.ThriftTypeDouble: JavaTypedouble,
}

var objecttypemapping = map[string]string{
	langs.ThriftTypeI16:    JavaTypeShort,
	langs.ThriftTypeI32:    JavaTypeInt,
	langs.ThriftTypeI64:    JavaTypeLong,
	langs.ThriftTypeString: JavaTypeString,
	langs.ThriftTypeByte:   JavaTypeByte,
	langs.ThriftTypeBool:   JavaTypeBool,
	langs.ThriftTypeDouble: JavaTypeDouble,
}

type JavaGen struct {
	langs.BaseGen
}

type BaseJava struct {
	Namespace string
	t         *parser.Thrift
	ts        map[string]*parser.Thrift
}

func (b *BaseJava) FilterVariableName(n string) string {
	if b.IsKeyword(n) {
		return fmt.Sprintf("t%s%s", strings.ToUpper(n[:1]), n[1:])
	}
	return n
}

func (b *BaseJava) IsKeyword(n string) bool {
	switch n {
	case "package", "int", "short", "long", "byte", "boolean", "case", "switch", "if ", "for", "else",
		"goto", "Integer", "Short", "Long", "Byte", "Boolean", "class", "break", "try", "catch",
		"double", "Double", "do", "while", "final", "finally", "continue", "interface", "private",
		"public", "protected", "return", "this", "throw", "static", "super", "throws",
		"true", "false", "float", "volatile", "synchronized", "abstract", "default", "extends",
		"native", "new":
		return true
	}
	return false
}

func (b *BaseJava) PlainTypecast(t *parser.Type) string {
	return b.typecast(t, true)
}

func (b *BaseJava) ObjectTypecast(t *parser.Type) string {
	return b.typecast(t, false)
}

func (b *BaseJava) typecast(t *parser.Type, isplain bool) string {
	if t == nil {
		if isplain {
			return "void"
		} else {
			return "Void"
		}
	}

	var typemapping map[string]string

	if isplain {
		typemapping = plaintypemapping
	} else {
		typemapping = objecttypemapping
	}

	if t, ok := typemapping[t.Name]; ok {
		return t
	}

	switch t.Name {
	case langs.ThriftTypeList, langs.ThriftTypeSet:
		return fmt.Sprintf("java.util.ArrayList<%s>", b.ObjectTypecast(t.ValueType))
	case langs.ThriftTypeMap:
		return fmt.Sprintf("java.util.Map<%s, %s>", b.ObjectTypecast(t.KeyType), b.ObjectTypecast(t.ValueType))
	default:
		s := strings.Split(t.Name, ".")
		if len(s) == 1 {
			return s[0]
		} else if len(s) == 2 {
			pkg := ""
			for k, v := range b.t.Includes {
				if k == s[0] {

					for p, t := range b.ts {
						if v == p {
							pkg = t.Namespaces[javaLang]
							break
						}
					}

					break
				}
			}

			if pkg == "" {
				return s[1]
			}
			return fmt.Sprintf("%s.%s", pkg, s[1])
		} else {
			return t.Name
		}
	}
}

func (b *BaseJava) AssembleParams(method *parser.Method) string {
	var buf bytes.Buffer

	for i, arg := range method.Arguments {
		if i != 0 {
			buf.WriteString(", ")
		}

		buf.WriteString(fmt.Sprintf("final %s %s", b.PlainTypecast(arg.Type), b.FilterVariableName(arg.Name)))
	}

	if len(method.Arguments) == 0 {
		buf.WriteString("")
	} else {
		buf.WriteString(", ")
	}

	buf.WriteString(fmt.Sprintf("final Listener<%s> listener", b.ObjectTypecast(method.ReturnType)))

	return buf.String()
}

func (b *BaseJava) GetInnerType(t *parser.Type) string {
	if t == nil {
		return "Void"
	}

	// map is ignored
	if t.Name == langs.ThriftTypeList || t.Name == langs.ThriftTypeSet {
		return b.GetInnerType(t.ValueType)
	}

	return b.ObjectTypecast(t)
}

// IsEnum checks whether a type is enum.
// it first checks in its own definition, than check from included files
func (b *BaseJava) IsEnum(t *parser.Type) bool {
	if t == nil {
		return false
	}

	names := strings.Split(t.Name, ".")

	if len(names) == 1 {
		for n := range b.t.Enums {
			if n == t.Name {
				return true
			}
		}

		return false
	}

	for path, thrift := range b.ts {
		if thrift == b.t {
			continue
		}

		filename := strings.TrimSuffix(filepath.Base(path), filepath.Ext(path))
		if filename != names[0] {
			continue
		}

		for n := range thrift.Enums {
			if n == names[1] {
				return true
			}
		}
	}

	return false
}

type javaEnum struct {
	*BaseJava
	*parser.Enum
}

func (e *javaEnum) GenerateProperties() string {
	size := len(e.Enum.Values)
	i := 0

	var buf bytes.Buffer
	for _, v := range e.Enum.Values {
		buf.WriteString(fmt.Sprintf("\t@SerializedName(\"%d\")\n", v.Value))
		buf.WriteString(fmt.Sprintf("\t%s(%d)", strings.ToUpper(v.Name), v.Value))
		if i == size-1 {
			buf.WriteString(";\n")
		} else {
			buf.WriteString(",\n")
		}
		i++
	}
	return buf.String()
}

type javaEnum struct {
	*BaseJava
	*parser.Enum
}

type javaStruct struct {
	*BaseJava
	*parser.Struct
}

func (this *javaStruct) HasKeyword() bool {
	for _, f := range this.Struct.Fields {
		if this.BaseJava.IsKeyword(f.Name) {
			return true
		}
	}
	return false
}

type javaService struct {
	*BaseJava
	*parser.Service
}

func generateAll(gen *JavaGen, output string, parsedThrift map[string]*parser.Thrift) {
	generateWithModel(gen, global.MODE_REST, filepath.Join(output, global.MODE_REST), parsedThrift)
	generateWithModel(gen, global.MODE_JSONRPC, filepath.Join(output, global.MODE_JSONRPC), parsedThrift)
}

func (g *JavaGen) Generate(output string, parsedThrift map[string]*parser.Thrift) {
	if global.Mode != "" {
		generateWithModel(g, global.Mode, output, parsedThrift)
	} else {
		generateAll(g, output, parsedThrift)
	}
}

func generateWithModel(gen *JavaGen, m string, output string, parsedThrift map[string]*parser.Thrift) {
	if m != global.MODE_REST && m != global.MODE_JSONRPC {
		log.Fatalf("mode '%s' is invalid", m)
	}

	gen.BaseGen.Init(javaLang, parsedThrift)

	if err := os.MkdirAll(output, 0755); err != nil {
		panic(fmt.Errorf("failed to create output directory %s", output))
	}

	// init templates
	enumTpl := initemplate(TPL_ENUM, "tmpl/java/enum.gojava")

	var structTpl *template.Template
	var serviceTpl *template.Template
	if m == global.MODE_REST {
		structTpl = initemplate(TPL_STRUCT, "tmpl/java/rest_struct.gojava")
		serviceTpl = initemplate(TPL_SERVICE, "tmpl/java/rest_service.gojava")
	} else if m == global.MODE_JSONRPC {
		structTpl = initemplate(TPL_STRUCT, "tmpl/java/jsonrpc_struct.gojava")
		serviceTpl = initemplate(TPL_SERVICE, "tmpl/java/jsonrpc_service.gojava")
	}

	// key is the absoule path of thrift file
	for _, t := range parsedThrift {
		// due to java's features,
		// we generate the struct and service in seperate template file

		ns := t.Namespaces["java"]

		if len(t.Enums) > 0 {
			log.Printf("## enums")

			for _, e := range t.Enums {
				name := e.Name + ".java"

				// fix java file path
				p := filepath.Join(output, strings.Replace(ns, ".", "/", -1))
				if err := os.MkdirAll(p, 0755); err != nil {
					panic(fmt.Errorf("failed to create output directory %s", p))
				}

				path := filepath.Join(p, name)

				base := BaseJava{Namespace: ns, t: t, ts: &parsedThrift}
				data := &javaEnum{BaseJava: &base, Enum: e}

				if err := outputfile(path, enumTpl, TPL_ENUM, data); err != nil {
					panic(fmt.Errorf("failed to write file %s. error: %v\n", path, err))
				}

				log.Printf("%s", path)
			}
		}

		log.Printf("## structs")

		for _, s := range t.Structs {
			// filename is the struct name
			name := s.Name + javaExt

			// fix java file path
			p := filepath.Join(output, strings.Replace(ns, ".", "/", -1))
			if err := os.MkdirAll(p, 0755); err != nil {
				panic(fmt.Errorf("failed to create output directory %s", p))
			}

			path := filepath.Join(p, name)

			base := BaseJava{Namespace: ns, t: t, ts: parsedThrift}
			data := &javaStruct{BaseJava: &base, Struct: s}

			if err := outputfile(path, structTpl, TPL_STRUCT, data); err != nil {
				panic(fmt.Errorf("failed to write file %s. error: %v\n", path, err))
			}

			log.Printf("%s", path)
		}

		log.Printf("## services")

		for _, s := range t.Services {
			// filename is the service name plus 'Service'
			name := s.Name + "Service" + javaExt

			// fix java file path
			p := filepath.Join(output, strings.Replace(ns, ".", "/", -1))
			if err := os.MkdirAll(p, 0755); err != nil {
				panic(fmt.Errorf("failed to create output directory %s", p))
			}

			path := filepath.Join(p, name)

			base := BaseJava{Namespace: ns, t: t, ts: parsedThrift}
			data := &javaService{BaseJava: &base, Service: s}

			if err := outputfile(path, serviceTpl, TPL_SERVICE, data); err != nil {
				panic(fmt.Errorf("failed to write file %s. error: %v\n", path, err))
			}

			log.Printf("%s", path)
		}
	}
}

func initemplate(n string, path string) *template.Template {
	data, err := tmpl.Asset(path)
	if err != nil {
		panic(err)
	}

	tpl := template.New(n)

	// register functions
	funcMap := template.FuncMap{
		"ToUpper": strings.ToUpper,
	}
	tpl.Funcs(funcMap)

	_, err = tpl.Parse(string(data))
	if err != nil {
		panic(err)
	}

	return tpl
}

func outputfile(fp string, t *template.Template, tplname string, data interface{}) error {
	file, err := os.OpenFile(fp, os.O_WRONLY|os.O_CREATE|os.O_TRUNC, 0644)
	if err != nil {
		return err
	}

	defer file.Close()

	return t.ExecuteTemplate(file, tplname, data)
}

func init() {
	langs.Langs[javaLang] = &JavaGen{}
}
