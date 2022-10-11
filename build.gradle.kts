import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
	id("org.springframework.boot") version "3.0.0-M5"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	kotlin("jvm") version "1.7.10"
	kotlin("plugin.spring") version "1.7.10"
	kotlin("plugin.allopen") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
	kotlin("kapt") version "1.6.21"
	checkstyle
}

group = "com.github.surajcm"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
}

dependencies {
	//errorprone("com.google.errorprone:error_prone_core:2.3.4")
	//errorproneJavac("com.google.errorprone:javac:9+181-r4173-1")

	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	//implementation("org.springframework.boot:spring-boot-starter-log4j2")
	runtimeOnly("org.springframework.boot:spring-boot-devtools")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	//implementation("org.hibernate:hibernate-core:5.2.15.Final")
	implementation("com.h2database:h2")
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
	implementation("jstl:jstl:1.2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testImplementation("org.junit.jupiter:junit-jupiter-params")

	testImplementation("org.mockito:mockito-core")
	testImplementation("org.powermock:powermock-api-mockito2:2.0.9")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<Checkstyle>().configureEach {
	reports {
		xml.required.set(false)
		html.required.set(true)
		html.stylesheet = resources.text.fromFile("config/xsl/checkstyle-custom.xsl")
	}
}

