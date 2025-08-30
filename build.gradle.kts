plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.5.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "hello"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

// // lombok 설정 추가 시작
// configurations {
//     compileOnly {
//         extendsFrom(configurations.annotationProcessor.get())
//     }
// }
// // lombok 설정 추가 끝

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

    // // lombok 라이브러리 추가 시작
    // compileOnly("org.projectlombok:lombok")
    // annotationProcessor("org.projectlombok:lombok")
    //
    // testCompileOnly("org.projectlombok:lombok")
    // testAnnotationProcessor("org.projectlombok:lombok")
    // // lombok 라이브러리 추가 끝

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
