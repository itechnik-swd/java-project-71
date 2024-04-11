run-dist:
	make -C run-dist

start:
	make -C app start

build:
	make -C app build

clean:
	make -C app clean

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

build-run:
	make -C app build-run

.PHONY: build