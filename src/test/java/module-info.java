// We must open all test packages so Junit can read them all.
open module nl.example.tests {
    requires nl.example.module;
    requires org.junit.jupiter.api;
}
