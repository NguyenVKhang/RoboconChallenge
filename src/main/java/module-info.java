module org.kbc2d {
    requires javafx.controls;
    requires javafx.web;
    requires javafx.media;
    requires kryonet;
    requires com.esotericsoftware.kryo;
    exports org.kbc2d;
    exports org.kbc2d.utils.multiplayer to com.esotericsoftware.kryo;
}
