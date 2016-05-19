all:

init:
	rm -f .git/hooks/pre-push
	ln -s ../../githooks/pre-push .git/hooks/pre-push
	go get github.com/samuel/go-thrift/parser
	go get -v github.com/spf13/cobra/cobra
	go get -u github.com/jteeuwen/go-bindata/...

test: buildTpl
	go test ./...

buildTpl:
	go-bindata -o tmpl/bindata.go -ignore bindata.go -pkg tmpl tmpl/*

debugTpl:
	go-bindata -o tmpl/bindata.go -ignore bindata.go -pkg tmpl -debug tmpl/*

gen-java: gen-java-rest gen-java-jsonrpc

gen-java-jsonrpc: buildTpl
	rm -rf output-java-jsonrpc
	go run main.go gen -l java -m jsonrpc -i example/java/ShipForMe.thrift -o ./output-java-jsonrpc

gen-java-rest: buildTpl
	rm -rf output-java-rest
	go run main.go gen -l java -m rest -i example/java/ShipForMe.thrift -o ./output-java-rest

gen-swift-rest: buildTpl
	rm -rf output-swift-rest
	go run main.go gen -l swift -m rest -i example/swift/Example.thrift -o ./output-swift-rest

gen-swift-jsonrpc: buildTpl
	rm -rf output-swift-jsonrpc
	go run main.go gen -l swift -m jsonrpc -i example/swift/Example.thrift -o ./output-swift-jsonrpc

gen-swift: gen-swift-rest gen-swift-jsonrpc

clean:
	go clean
	rm -rf ./output-swift-rest
	rm -rf ./output-swift-jsonrpc
	rm -rf ./output-java-rest
	rm -rf ./output-java-jsonrpc

build:
	go clean
	go build
	open .
