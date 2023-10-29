module com.example.decimaabinario {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.decimaabinario to javafx.fxml;
    exports com.example.decimaabinario;
}