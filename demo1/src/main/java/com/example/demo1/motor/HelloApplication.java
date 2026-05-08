package com.example.demo1.motor;

import com.example.demo1.modeo.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    Pane root;

    Personaje jugador;
    Inventario inventario;

    ImageView playerView;

    List<Obstaculo> obstaculos = new ArrayList<>();
    List<ImageView> obsViews = new ArrayList<>();
    List<ImageView> balas = new ArrayList<>();

    List<Utileria> utilerias = new ArrayList<>();
    List<ImageView> utilViews = new ArrayList<>();

    CheckPoint checkpoint;

    boolean w, s, a, d;

    int vidas = 3;
    boolean fin = false;

    Text mensaje;
    Text vidasText;
    Text inventarioText;

    int inicioX = 100;
    int inicioY = 100;

    ImageView tesoroView;
    Recompensa tesoroFinal;

    String archivoJugador = "jugador.txt";
    String archivoInventario = "inventario.txt";
    String archivoEscenario = "escenario.txt";

    @Override
    public void start(Stage stage) {

        root = new Pane();

        BorderPane layout = new BorderPane();

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Juego");

        MenuItem guardar = new MenuItem("Guardar");
        MenuItem cargar = new MenuItem("Cargar");
        MenuItem reiniciar = new MenuItem("Reiniciar");
        MenuItem salir = new MenuItem("Salir");

        menu.getItems().addAll(
                guardar,
                cargar,
                reiniciar,
                salir
        );

        menuBar.getMenus().add(menu);

        guardar.setOnAction(e -> {

            guardarJugador();
            guardarInventario();
            guardarEscenario();

            evento("Juego guardado");
        });

        cargar.setOnAction(e -> {

            cargarJugador();
            cargarInventario();
            cargarEscenario();

            evento("Juego cargado");
        });

        reiniciar.setOnAction(e -> reiniciar());

        salir.setOnAction(e -> stage.close());

        layout.setTop(menuBar);
        layout.setCenter(root);

        Scene scene = new Scene(layout, 900, 600);

        fondo();
        iniciar();
        ui();

        scene.setOnKeyPressed(e -> {

            if (fin) return;

            if (e.getCode() == KeyCode.W) w = true;
            if (e.getCode() == KeyCode.S) s = true;
            if (e.getCode() == KeyCode.A) a = true;
            if (e.getCode() == KeyCode.D) d = true;

            if (e.getCode() == KeyCode.SPACE) {

                disparar();
            }
        });

        scene.setOnKeyReleased(e -> {

            if (e.getCode() == KeyCode.W) w = false;
            if (e.getCode() == KeyCode.S) s = false;
            if (e.getCode() == KeyCode.A) a = false;
            if (e.getCode() == KeyCode.D) d = false;
        });

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (!fin) {

                    mover();
                    moverBalas();
                    colisiones();
                }
            }
        }.start();

        stage.setScene(scene);

        stage.setTitle("Juego Completo");

        stage.show();
    }

    Image img(String path) {

        URL url = getClass().getResource(path);

        if (url == null) return null;

        return new Image(url.toExternalForm());
    }

    void fondo() {

        ImageView bg = new ImageView(
                img("/imagenes/background.png")
        );

        bg.setFitWidth(900);
        bg.setFitHeight(600);

        root.getChildren().add(bg);

        bg.toBack();
    }

    void iniciar() {

        jugador = new Personaje(
                "Heroe",
                100,
                inicioX,
                inicioY
        );

        playerView = new ImageView(
                img("/imagenes/player.jpg")
        );

        playerView.setFitWidth(50);
        playerView.setFitHeight(50);

        playerView.setX(inicioX);
        playerView.setY(inicioY);

        root.getChildren().add(playerView);

        inventario = new Inventario(10);

        checkpoint = new CheckPoint(
                "Inicio",
                inicioX,
                inicioY
        );

        checkpoint.activar();

        crearEnemigos(5);

        Utileria u = new Utileria(
                "Botiquin",
                "cura",
                350,
                300
        );

        utilerias.add(u);

        ImageView uv = new ImageView(
                img("/imagenes/coin.png")
        );

        uv.setX(350);
        uv.setY(300);

        uv.setFitWidth(30);
        uv.setFitHeight(30);

        utilViews.add(uv);

        root.getChildren().add(uv);

        tesoroFinal = new Recompensa(
                "Tesoro Final",
                500,
                "victoria"
        );

        tesoroView = new ImageView(
                img("/imagenes/coin.png")
        );

        tesoroView.setX(800);
        tesoroView.setY(500);

        tesoroView.setFitWidth(40);
        tesoroView.setFitHeight(40);

        root.getChildren().add(tesoroView);
    }

    void crearEnemigos(int cantidad) {

        for (int i = 0; i < cantidad; i++) {

            Obstaculo o = new Obstaculo(
                    "obs",
                    10,
                    200 + i * 120,
                    200,
                    30
            );

            obstaculos.add(o);

            ImageView v = new ImageView(
                    img("/imagenes/obstacle.png")
            );

            v.setX(o.getPosicionX());
            v.setY(o.getPosicionY());

            v.setFitWidth(50);
            v.setFitHeight(50);

            obsViews.add(v);

            root.getChildren().add(v);
        }
    }

    void ui() {

        mensaje = new Text(300, 250, "");

        mensaje.setStyle(
                "-fx-font-size: 28px; -fx-fill: red;"
        );

        vidasText = new Text(
                10,
                20,
                "Vidas: " + vidas
        );

        inventarioText = new Text(
                10,
                40,
                "Inventario: 0 items"
        );

        root.getChildren().addAll(
                mensaje,
                vidasText,
                inventarioText
        );
    }

    void actualizarHUD() {

        vidasText.setText("Vidas: " + vidas);

        inventarioText.setText(
                "Inventario: "
                        + inventario.getItems().size()
                        + " items"
        );
    }

    void evento(String texto) {

        mensaje.setText(texto);
    }

    void perderVida() {

        vidas--;

        if (vidas < 0) vidas = 0;

        actualizarHUD();

        evento("Perdiste una vida");

        if (vidas == 0) {

            morir();

        } else {

            respawn();
        }
    }

    void respawn() {

        jugador.setPosicion(
                checkpoint.getPosicionX(),
                checkpoint.getPosicionY()
        );

        playerView.setX(
                checkpoint.getPosicionX()
        );

        playerView.setY(
                checkpoint.getPosicionY()
        );

        evento("Regresaste al checkpoint");
    }

    void mover() {

        if (s) jugador.mover("norte", 4);
        if (w) jugador.mover("sur", 4);
        if (a) jugador.mover("oeste", 4);
        if (d) jugador.mover("este", 4);

        int x = jugador.getPosicionX();
        int y = jugador.getPosicionY();

        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x > 850) x = 850;
        if (y > 550) y = 550;

        jugador.setPosicion(x, y);

        playerView.setX(x);
        playerView.setY(y);
    }

    void disparar() {

        ImageView bala = new ImageView(
                img("/imagenes/coin.png")
        );

        bala.setFitWidth(10);
        bala.setFitHeight(10);

        bala.setX(playerView.getX() + 20);
        bala.setY(playerView.getY() + 20);

        balas.add(bala);

        root.getChildren().add(bala);

        evento("Disparo realizado");
    }

    void moverBalas() {

        for (int i = 0; i < balas.size(); i++) {

            ImageView b = balas.get(i);

            b.setX(b.getX() + 8);

            if (b.getX() > 900) {

                root.getChildren().remove(b);

                balas.remove(i);

                i--;
            }
        }
    }

    void colisiones() {

        for (int i = 0; i < obsViews.size(); i++) {

            ImageView obs = obsViews.get(i);

            Obstaculo o = obstaculos.get(i);

            for (int j = 0; j < balas.size(); j++) {

                ImageView b = balas.get(j);

                if (b.getBoundsInParent()
                        .intersects(obs.getBoundsInParent())) {

                    o.recibirDano(10);

                    root.getChildren().remove(b);

                    balas.remove(j);

                    j--;

                    evento("Obstáculo dañado");
                }
            }

            if (playerView.getBoundsInParent()
                    .intersects(obs.getBoundsInParent())) {

                jugador.recibirDano(o.getDano());

                perderVida();
            }

            if (o.isDestruido()) {

                inventario.agregarItem(
                        new Recompensa(
                                "Moneda",
                                50,
                                "oro"
                        )
                );

                actualizarHUD();

                root.getChildren().remove(obs);

                obsViews.remove(i);

                obstaculos.remove(i);

                i--;
            }
        }

        for (int i = 0; i < utilViews.size(); i++) {

            ImageView uv = utilViews.get(i);

            if (playerView.getBoundsInParent()
                    .intersects(uv.getBoundsInParent())) {

                inventario.agregarItem(
                        new Recompensa(
                                "Vida",
                                20,
                                "cura"
                        )
                );

                actualizarHUD();

                evento("Item recogido");

                root.getChildren().remove(uv);

                utilViews.remove(i);

                utilerias.remove(i);

                i--;
            }
        }

        if (playerView.getBoundsInParent()
                .intersects(tesoroView.getBoundsInParent())) {

            fin = true;

            evento("¡GANASTE EL TESORO!");

            inventario.agregarItem(tesoroFinal);
        }
    }

    void morir() {

        evento("GAME OVER");

        fin = true;
    }

    void reiniciar() {

        root.getChildren().clear();

        obstaculos.clear();
        obsViews.clear();
        balas.clear();
        utilerias.clear();
        utilViews.clear();

        vidas = 3;
        fin = false;

        fondo();
        iniciar();
        ui();
    }

    // =========================
    // ARCHIVOS DE TEXTO
    // =========================

    void guardarJugador() {

        try {

            PrintWriter pw = new PrintWriter(
                    new FileWriter(archivoJugador)
            );

            pw.println((int) playerView.getX());
            pw.println((int) playerView.getY());
            pw.println(vidas);

            pw.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al guardar jugador"
            );
        }
    }

    void cargarJugador() {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(archivoJugador)
            );

            int x = Integer.parseInt(
                    br.readLine()
            );

            int y = Integer.parseInt(
                    br.readLine()
            );

            vidas = Integer.parseInt(
                    br.readLine()
            );

            br.close();

            jugador.setPosicion(x, y);

            playerView.setX(x);
            playerView.setY(y);

            actualizarHUD();

        } catch (Exception e) {

            System.out.println(
                    "Error al cargar jugador"
            );
        }
    }

    void guardarInventario() {

        try {

            PrintWriter pw = new PrintWriter(
                    new FileWriter(archivoInventario)
            );

            pw.println(
                    inventario.getItems().size()
            );

            pw.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al guardar inventario"
            );
        }
    }

    void cargarInventario() {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(archivoInventario)
            );

            int cantidad = Integer.parseInt(
                    br.readLine()
            );

            inventarioText.setText(
                    "Inventario: "
                            + cantidad
                            + " items"
            );

            br.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al cargar inventario"
            );
        }
    }

    void guardarEscenario() {

        try {

            PrintWriter pw = new PrintWriter(
                    new FileWriter(archivoEscenario)
            );

            // Guardar enemigos restantes
            pw.println(obstaculos.size());

            pw.close();

        } catch (Exception e) {

            System.out.println(
                    "Error al guardar escenario"
            );
        }
    }

    void cargarEscenario() {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(archivoEscenario)
            );

            int cantidad = Integer.parseInt(
                    br.readLine()
            );

            br.close();

            // Eliminar enemigos actuales
            for (ImageView obs : obsViews) {

                root.getChildren().remove(obs);
            }

            obstaculos.clear();
            obsViews.clear();

            // Crear SOLO enemigos restantes
            crearEnemigos(cantidad);

        } catch (Exception e) {

            System.out.println(
                    "Error al cargar escenario"
            );
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}