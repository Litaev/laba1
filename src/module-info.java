module demo.parallel.laba1 {
    requires javafx.controls;
    requires javafx.graphics;

    opens demo.parallel to javafx.graphics;
    exports demo.parallel;
}