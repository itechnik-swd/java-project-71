install-with-json:
	./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

install-with-yaml:
	./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

run-dist:
	./build/install/app/bin/app

start:
	./gradlew run

build:
	./gradlew build

clean:
	./gradlew clean

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

build-run: build run-dist

.PHONY: build