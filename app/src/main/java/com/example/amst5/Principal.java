package com.example.amst5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {
    ArrayList<Libro> db;
    LinearLayout info;
    EditText et;
    String[] libros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        info = findViewById(R.id.scroll);
        db = createDatabase();
        et = findViewById(R.id.busqueda);
        agregarInfo(info);


    }



    public ArrayList<Libro> createDatabase( ){
        ArrayList<Libro> basedatos = new ArrayList<>();
        String book1=  "Romeo y Julieta|William Shakespeare|Juventud|Romance|En Verona, dos jóvenes enamorados, de dos familias enemigas, son víctimas de una situación de odio y violencia que ni desean ni pueden remediar. En una de esas tardes de verano en que el calor inflama la sangre, Romeo, recién casado en secreto con su amada Julieta, mata al primo de ésta.|romeoyjulieta.jpg";
        String book2=  "50 sombras de Grey|E L James|GRIJALBO|Romance|Cuando la joven Anastasia conoce al poderoso y enigmático Christian Grey, comienzan un excitante, sensual y atormentado romance. Erótica, entretenida y profundamente conmovedora, la serie Cincuenta sombras es una historia que te cautivará, te poseerá y se quedará contigo por siempre.|cincuentasombras.jpg";
        String book3=  "Crepúsculo|Robert Abele|Libros Cúpula|Romance|Te quedas sin opciones cuando amas a tu potencial asesino. ¿Acaso es posible huir o luchar si eso debe causar un grave perjuicio a quien quieres? Si la vida es cuanto puedes darle y de verdad le amas por encima de todo, ¿por que no entregarla? Ahora que Bella ha tomado una decisión, una inesperada cadena de acontecimientos está a punto de desatarse, con consecuencias inimaginables y potencialmente devastadoras.|crepusculo.jpg";
        String book4=  "Bajo la misma estrella|John Green|Nube de Tinta|Romance|A Hazel y a Gus les gustaría tener vidas más corrientes. Algunos dirían que no han nacido con estrella, que su mundo es injusto. Hazel y Gus son solo adolescentes, pero si algo les ha enseñado el cáncer que ambos padecen es que no hay tiempo para lamentaciones, porque, nos guste o no, solo existe el hoy y el ahora.|bajolamismaestrella.jpg";
        String book5=  "Frankenstein|Mary Shelley|Vicens Vives|Terror|Obsesionado por desentrañar los secretos de la naturaleza y descubrir el principio de la vida, el joven Victor Frankenstein se enfrasca en la creación de un ser humano, para lo cual saquea tumbas y ensambla miembros de cadáveres, a los que les aplica la “chispa vital” de la corriente eléctrica. Sin embargo, tan pronto como cobra vida, la monstruosa criatura es rechazada por el atormentado cientíﬁco y perseguida y maltratada por las gentes, pese a la bondad con que se comporta.|frankenstein.jpg";
        String book6=  "Soy Leyenda|Richard Matheson|Booklet|Terror|Robert Neville es el único superviviente de una guerra bacteriológica que ha asolado el planeta y convertido al resto de la humanidad en vampiros. Su vida se ha reducido a asesinar el máximo número posible de estos seres sanguinarios durante el día, y a soportar su asedio cada noche.|soyleyenda.jpg";
        String book7=  "Aniquilación|Jeff VanderMeer|Destino|Terror|Este libro de ciencia ficción y terror es lo más parecido a Lovecraft que encontramos a día de hoy. Pero no un Lovecraft que copia e imita al maestro, sino una versión muy original de un terror cósmico al estilo del maestro.|aniquilacion.jpg";
        String book8=  "Drácula|Bram Stoker|Debolsillo|Terror|La narración está ambientada en dos localidades diferentes, entre Inglaterra y Transilvania en el año 1890. El relato inicia cuando Jonathan Harker, quien es un abogado joven debe trasladarse al hogar del Conde Drácula en Transilvania en beneficio de su jefe para brindar apoyo legal concerniente a una negociación de bienes raíces. Harker comienza a verse influenciado por Drácula y es atacado por las sirenas vampiro lo que hace que apenas salga con vida del castillo.|dracula.jpg";
        String book9=  "Viaje al Centro de la tierra|Julio Verne|Alfaguara|Ficción|Viaje al Centro de la Tierra no es más que el relato de una odisea por el mundo subterráneo, entrando desde Islandia. Los participantes activos de la excursión son Otto Lidenbrock, su sobrino Axel y el guía nativo Hans. A partir de un texto de Arne Saknussemm, el científico se plantea si no habrá una galería por la que se pueda acceder al Centro de la Tierra. Tras descifrarlo de una manera extraordinaria, se ponen en marcha con una increíble motivación, dando fe de las grandes inquietudes por el avance científico y por el enriquecimiento personal que puede aportarles este viaje.|viajealcentrodelatierra.jpg";
        String book10= "Fahrenheit 451|Ray Bradbury|Debolsillo|Ficción|La temperatura a la que el papel se enciende y arde. Guy Montag es un bombero y el trabajo de un bombero es quemar libros, que están prohibidos porque son causa de discordia y sufrimiento.|fahrenheit.jpg";
        String book11= "1984|George Orwell|Penguin Readers|Ficción|Es una novela de distopía cuya trama ocurre en Oceanía, un país dominado por un gobierno totalitario que mantiene en constante vigilancia a sus ciudadanos e, incluso, insiste en espiar sus pensamientos para mantener el orden.|1984.jpg";
        String book12= "LOS JUEGOS DEL HAMBRE|SUZANNE COLLINS|RBA Libros|Ficción|Es la hora. Ya no hay vuelta atrás. Los juegos van a comenzar. Los tributos deben salir a la Arena y luchar por sobrevivir.Ganar significa Fama y riqueza, perder significa la muerte segura...|hambre.jpg ";
        String book13= "El principito|Antoine de Saint-Exupery|Salamandra|Cuento|En ella, se narra la historia de un piloto que intenta reparar su avión estropeado en medio del desierto del Sahara y quien justo allí se topa con un pequeño príncipe originario de otro planeta, iniciándose así una relación de amistad entre ambos, llegándose a detallar entre sí las anécdotas, particularidades, visiones y percepciones de diversos temas que rodean sus vidas.|principito.jpg";
        String book14= "Alicia en el Pais de las Maravillas|Lewis Carroll|Arrobabooks|Cuento|A lo largo de esta odisea, Alicia sufrirá diversas transformaciones e interactuará con un sinfín de personajes donde experimentará vivencias particulares con cada uno de ellos y que definen en conjunto el verdadero significado de las andanzas que emprende Alicia.|alicia.jpg";
        String book15= "Cuentos de la selva|Horacio Quiroga|Anaya|Cuento|El argumento de estos relatos, con alto sentido ecológico e independientes unos de otros, caracteriza diversas vivencias anecdóticas enfatizadas en las relaciones tanto de unión como rivalidad que llegan a desarrollar los animales y los humanos entre sí y cómo el desenlace de estas transmite de forma reflexiva el respeto, la estima y la consideración que se debe tener por la naturaleza.|cuentosdelaselva.jpg";
        String book16= "Las aventuras de pinocho|Carlo Collodi|Siruela|Cuento|Es un cuento que narra las vivencias que experimenta Pinocho, una marioneta de madera creada por Geppetto, un viejo carpintero, a lo largo de treinta y seis capítulos donde se describe el agitado viaje que le llevará a lugares y situaciones impensables junto a una diversidad de personajes que le acompañan durante su odisea, en la que además de querer volver a casa está el persistente deseo de poder convertirse en un niño real.|aventuradepinocho.jpg";
        libros = new String[]{book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12, book13, book14, book15, book16};
        for(String s : libros){
            String[] cortado = s.split("\\|");
            basedatos.add(new Libro(cortado[0], cortado[3], cortado[1], cortado[2], cortado[4], cortado[5]));
            String l = cortado[0]+" " +cortado[1]+" " + cortado[2]+" " + cortado[3]+" " + cortado[4]+" " + cortado[5];
            System.out.println(l);
        }
        return basedatos;
    }

    public void agregarInfo(LinearLayout ll) {
        for (Libro l : db) {
            LinearLayout llh = new LinearLayout(ll.getContext());
            llh.setOrientation(LinearLayout.HORIZONTAL);

            EditText imagen = new EditText(llh.getContext());
            imagen.setText(l.getRuta());
            LinearLayout llv = new LinearLayout(llh.getContext());
            llv.setOrientation(LinearLayout.VERTICAL);
            EditText titulo = new EditText(llv.getContext());
            titulo.setText(l.getTitulo());
            System.out.println(l.getTitulo());
            EditText autor = new EditText(llv.getContext());
            autor.setText(l.getAutor());
            System.out.println(l.getAutor());
            EditText editorial = new EditText(llv.getContext());
            editorial.setText(l.getEditorial());
            System.out.println(l.getEditorial());
            EditText categoria = new EditText(llv.getContext());
            categoria.setText(l.getCategoria());
            System.out.println(l.getCategoria());
            System.out.println(l.getRuta());
            System.out.println();
            llv.addView(titulo);
            llv.addView(autor);
            llv.addView(editorial);
            llv.addView(categoria);
            llh.addView(imagen);
            llh.addView(llv);
            ll.addView(llh);

        }
    }
        //botones
        public void categoria(View view){
            Intent i = new Intent(this, CategoriaC.class);
            //i.putExtra("direccion", et1.getText().toString());
            startActivity(i);
            finish();
        }
    public void perfil(View view){
        Intent i = new Intent(this, Perfil.class);
        //i.putExtra("direccion", et1.getText().toString());
        startActivity(i);
        finish();
    }
    public void principal(View view){
        Intent i = new Intent(this, Principal.class);
        //i.putExtra("direccion", et1.getText().toString());
        startActivity(i);
        finish();
    }






}