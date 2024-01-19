BUILD_TYPE ?= Debug
GRADLE_ARGS ?= --build-cache

all: clean lint assemble
.PHONY: all

assemble:
	./gradlew assemble${BUILD_TYPE} ${GRADLE_ARGS}
.PHONY: assemble

build:
	./gradlew build${BUILD_TYPE} ${GRADLE_ARGS}
.PHONY: build

bundle:
	./gradlew bundle${BUILD_TYPE} ${GRADLE_ARGS}
.PHONY: bundle

clean:
	./gradlew clean ${GRADLE_ARGS}
.PHONY: clean

lint:
	./gradlew lint${BUILD_TYPE}
.PHONY: lint
