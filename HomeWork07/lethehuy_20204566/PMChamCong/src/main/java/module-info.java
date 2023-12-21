module main.pmchamcong {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens main.pmchamcong to javafx.fxml;
    exports main.pmchamcong;
}