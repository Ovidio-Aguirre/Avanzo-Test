package com.example.quizonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizonline.databinding.ActivityMainBinding

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quizModelList : MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizModelList = mutableListOf()
        getDataFromFirebase()


    }

   private fun setupRecyclerView(){
        binding.progressBar.visibility = View.GONE
        adapter = QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getDataFromFirebase(){
        //datos quemados
        val listQuestionModelLenguaje = mutableListOf<QuestionModel>()
        val listQuestionModelSociales = mutableListOf<QuestionModel>()
        val listQuestionModelCiencias = mutableListOf<QuestionModel>()
        val listQuestionModelMatematicas = mutableListOf<QuestionModel>()

        listQuestionModelLenguaje.add(QuestionModel("Selecciona la opción que presenta una oración simple.",mutableListOf("Dio un paso atrás y dijo con una cierta aflicción: —Quiero advertirle que estoy armado. ","Don Apolinar Moscote, alquiló un cuartito, a dos cuadras de la casa de los Buendía.","Fueron con sus hijos a ponerse a disposición de Arcadio Buendía, pero él se opuso.","Agarró a Don Apolinar Moscote, lo levantó a la altura de sus ojos y lo sacó del pueblo.",),"Don Apolinar Moscote, alquiló un cuartito, a dos cuadras de la casa de los Buendía."/*esta es la respuesta*/))
        listQuestionModelLenguaje.add(QuestionModel("¿Qué es un sustantivo?",mutableListOf("Una palabra que describe una acción","Una palabra que sustituye a un nombre","Una palabra que designa un objeto o ser","Una palabra que indica lugar",),"Una palabra que designa un objeto o ser"/*esta es la respuesta*/))
        listQuestionModelLenguaje.add(QuestionModel("¿Cuál de las siguientes palabras es un adverbio?",mutableListOf("Casa","Felicidad","Rápidamente","Hermoso",),"Rápidamente"/*esta es la respuesta*/))
        listQuestionModelLenguaje.add(QuestionModel("¿Cuál es el sinónimo de la palabra \"bonito\"?",mutableListOf("Feo","Hermoso","Malo","Bajo",),"Hermoso"/*esta es la respuesta*/))
        listQuestionModelLenguaje.add(QuestionModel("¿Cuál de las siguientes oraciones es imperativa?",mutableListOf(" Él está cantando."," ¿Dónde está el libro?","Por favor, cierra la puerta."," ¡Qué hermoso es el mar!",),"Por favor, cierra la puerta."/*esta es la respuesta*/))
        listQuestionModelLenguaje.add(QuestionModel("¿Cuál es el complemento directo en la oración \"Juan compró un libro para su hermana\"?",mutableListOf("Juan","Compró"," Un libro","Para su hermana",)," Un libro"/*esta es la respuesta*/))
        listQuestionModelLenguaje.add(QuestionModel("¿Qué tipo de palabra es \"especialmente\" en la oración \"El libro es especialmente interesante\"?",mutableListOf("Adjetivo","Sustantivo","Adverbio","Verbo",),"Adverbio"/*esta es la respuesta*/))
        listQuestionModelLenguaje.add(QuestionModel("¿Cuál es el significado de \"elipsis\" en gramática?",mutableListOf("Omitir una letra","Omitir un sonido","Omitir una palabra o frase"," Omitir un párrafo",),"Omitir una palabra o frase"/*esta es la respuesta*/))
        listQuestionModelLenguaje.add(QuestionModel("¿Cuál es el tiempo verbal en la oración \"Si hubieras estudiado, habrías aprobado\"?",mutableListOf("Presente perfecto","Presente perfecto","Futuro perfecto","Pluscuamperfecto",),"Condicional perfecto"/*esta es la respuesta*/))
        listQuestionModelLenguaje.add(QuestionModel("¿Cuál es la figura retórica utilizada en la frase \"El sol me sonríe cada mañana\"?",mutableListOf("Hipérbole","Símil","Metáfora","Personificación",),"Personificación"/*esta es la respuesta*/))


        quizModelList.add(QuizModel("1","Lenguaje","preguntas Lenguaje ","15",listQuestionModelLenguaje));


        //sociales
        listQuestionModelSociales.add(QuestionModel("¿Quién fue el presidente de El Salvador que firmó los Acuerdos de Paz de Chapultepec en 1992?",mutableListOf(" Alfredo Cristiani","Armando Calderón Sol","Francisco Flores","Mauricio Funes",)," Alfredo Cristiani"/*esta es la respuesta*/))
        listQuestionModelSociales.add(QuestionModel("¿Cuál es el volcán más alto de El Salvador?",mutableListOf("Volcán de Izalco","Volcán de San Salvador","Volcán de Santa Ana","Volcán de San Miguel",),"Volcán de Santa Ana"/*esta es la respuesta*/))
        listQuestionModelSociales.add(QuestionModel("¿Quién es considerado el héroe nacional de El Salvador por liderar la lucha contra la invasión del filibustero William Walker en 1856?",mutableListOf("Gerardo Barrios","Francisco Morazán","José Matías Delgado","Juan José Cañas",),"Gerardo Barrios"/*esta es la respuesta*/))
        listQuestionModelSociales.add(QuestionModel("¿Cuál es el nombre del lago más grande de El Salvador?",mutableListOf("Lago de Coatepeque","Lago de Ilopango","Lago Suchitlán","Lago de Güija",),"Lago de Güija"/*esta es la respuesta*/))
        listQuestionModelSociales.add(QuestionModel("¿Cuál es la moneda oficial de El Salvador?",mutableListOf("Peso salvadoreño","Quetzal","Colón salvadoreño","Dólar estadounidense",),"Dólar estadounidense"/*esta es la respuesta*/))
        listQuestionModelSociales.add(QuestionModel("¿Cuál es la fecha de la Independencia de El Salvador?",mutableListOf("15 de septiembre de 1821","15 de septiembre de 1810","15 de septiembre de 1838","5 de noviembre de 1811",),"15 de septiembre de 1821"/*esta es la respuesta*/))
        listQuestionModelSociales.add(QuestionModel("¿Quién fue el presidente de El Salvador durante la guerra civil que tuvo lugar entre 1980 y 1992?",mutableListOf("José Napoleón Duarte","Armando Calderón Sol","Mauricio Funes","Nayib Bukele",),"José Napoleón Duarte"/*esta es la respuesta*/))
        listQuestionModelSociales.add(QuestionModel("¿Cuál es el plato típico más conocido de El Salvador?",mutableListOf("Pupusa","Tamal","Yuca frita","Sopa de mondongo",),"Pupusa"/*esta es la respuesta*/))
        listQuestionModelSociales.add(QuestionModel("¿Cuál es la ciudad más poblada de El Salvador?",mutableListOf("San Salvador","Santa Ana","San Miguel","Soyapango",),"resp_4"/*esta es la respuesta*/))
        listQuestionModelSociales.add(QuestionModel("¿Quién es considerado el poeta más importante de El Salvador y es conocido como \"El Príncipe de las Letras Castellanas\"?",mutableListOf("Roque Dalton","Claudia Lars","Francisco Gavidia","Alfredo Espino",),"Francisco Gavidia"/*esta es la respuesta*/))



        quizModelList.add(QuizModel("2","Sociales","preguntas de sociales ","15",listQuestionModelSociales));

        //Ciencias
        listQuestionModelCiencias.add(QuestionModel("¿Cuál es el nombre del proceso por el cual las plantas convierten la luz solar en energía química?",
            mutableListOf("Respiración celular", "Fotosíntesis", "Quimiosíntesis", "Fermentación"),
            "Fotosíntesis"))
        listQuestionModelCiencias.add(QuestionModel("¿Cuál es el elemento más abundante en el universo?",
            mutableListOf("Oxígeno", "Hidrógeno", "Carbono", "Nitrógeno"),
            "Hidrógeno"))
        listQuestionModelCiencias.add(QuestionModel("¿Cuál es el nombre de la parte de la célula que controla la actividad celular y contiene el material genético?",
            mutableListOf("Mitocondria", "Membrana celular", "Núcleo", "Citoplasma"),
            "Núcleo"))
        listQuestionModelCiencias.add(QuestionModel("¿Qué ley de Newton describe la relación entre la fuerza, la masa y la aceleración?",
            mutableListOf("Primera Ley", "Segunda Ley", "Tercera Ley", "Ley de la gravedad"),
            "Segunda Ley"))
        listQuestionModelCiencias.add(QuestionModel("¿Cuál es el nombre de la molécula que transporta oxígeno en la sangre?",
            mutableListOf("Insulina", "Glucosa", "Hemoglobina", "Plasma"),
            "Hemoglobina"))
        listQuestionModelCiencias.add(QuestionModel("¿Cuál es el nombre del compuesto químico con la fórmula H₂O₂?",
            mutableListOf("Agua", "Peróxido de hidrógeno", "Dióxido de carbono", "Ácido sulfúrico"),
            "Peróxido de hidrógeno"))
        listQuestionModelCiencias.add(QuestionModel("¿Cuál es el planeta más grande del sistema solar?",
            mutableListOf("Marte", "Saturno", "Júpiter", "Urano"),
            "Júpiter"))
        listQuestionModelCiencias.add(QuestionModel( "¿Cuál es el nombre de la capa más externa de la Tierra?",
            mutableListOf("Núcleo", "Manto", "Corteza", "Placa tectónica"),
            "Corteza"))
        listQuestionModelCiencias.add(QuestionModel("¿Cuál es el nombre del proceso por el cual una célula se divide en dos células hijas idénticas?",
            mutableListOf("Mitosis", "Meiosis", "Fisión binaria", "Fragmentación"),
            "Mitosis"))
        listQuestionModelCiencias.add(QuestionModel("¿Cuál es el nombre del ácido que se encuentra en el estómago y ayuda en la digestión?",
            mutableListOf("Ácido sulfúrico", "Ácido nítrico", "Ácido láctico", "Ácido clorhídrico"),
            "Ácido clorhídrico"))

        quizModelList.add(QuizModel("3","Ciencias","preguntas de Ciencias naturales ","15",listQuestionModelCiencias));


        //matematicas
        listQuestionModelMatematicas.add(
            QuestionModel(
                "¿Cuál es la derivada de \"(f(x) = x^3 + 3x^2 + 2x\")?",
                mutableListOf("3x^2 + 6x + 2", "3x^2 + 2x + 3", "3x^2 + 6x", "3x^2 + 6"),
                "3x^2 + 6x + 2" /*esta es la respuesta*/
            )
        )

        listQuestionModelMatematicas.add(
            QuestionModel(
                "¿Cuál es la integral indefinida de \"(f(x) = 2x + 5\")?",
                mutableListOf("x^2 + 5x + C", "2x^2 + 5x + C", "x^2 + 2x + C", "x^2 + C"),
                "x^2 + 5x + C" /*esta es la respuesta*/
            )
        )

        listQuestionModelMatematicas.add(
            QuestionModel(
                "¿Cuál es el valor de \"(x)\" en la ecuación \"(2x^2 - 8 = 0\")?",
                mutableListOf("x = 2", "x = -2", "x = ±2", "x = 4"),
                "x = ±2" /*esta es la respuesta*/
            )
        )

        listQuestionModelMatematicas.add(
            QuestionModel(
                "¿Cuál es el límite de \"(f(x) = \"dfrac{2x - 4}{x - 2})\" cuando \"(x)\" tiende a 2?",
                mutableListOf("Infinito", "1", "0", "2"),
                "Infinito" /*esta es la respuesta*/
            )
        )

        listQuestionModelMatematicas.add(
            QuestionModel(
                "¿Cuál es el área de un círculo con radio \"(r = 5\")?",
                mutableListOf("25π", "50π", "75π", "100π"),
                "25π" /*esta es la respuesta*/
            )
        )

        listQuestionModelMatematicas.add(
            QuestionModel(
                "¿Cuál es el ángulo exterior de un triángulo equilátero?",
                mutableListOf("30°", "60°", "90°", "120°"),
                "120°" /*esta es la respuesta*/
            )
        )

        listQuestionModelMatematicas.add(
            QuestionModel(
                "¿Cuál es el valor de \"(x\") en la ecuación \"(x^2 + 6x + 9 = 0\")?",
                mutableListOf("x = -3", "x = 3", "x = ±3", "x = 0"),
                "x = -3" /*esta es la respuesta*/
            )
        )

        listQuestionModelMatematicas.add(
            QuestionModel(
                "¿Cuál es la ecuación de la recta que pasa por el punto \"((2, 3)\") y tiene una pendiente de \"(4\")?",
                mutableListOf("y = 4x + 3", "y = 4x - 5", "y = 4x - 1", "y = 4x - 7"),
                "y = 4x - 5" /*esta es la respuesta*/
            )
        )

        listQuestionModelMatematicas.add(
            QuestionModel(
                "¿Cuál es el volumen de un cilindro con radio \"(r = 3\") y altura \"(h = 5\")?",
                mutableListOf("15π", "30π", "45π", "90π"),
                "45π" /*esta es la respuesta*/
            )
        )

        listQuestionModelMatematicas.add(
            QuestionModel(
                "¿Cuál es el seno de un ángulo de 30°?",
                mutableListOf("0.5", "0.866", "1", "0"),
                "0.5" /*esta es la respuesta*/
            )
        )

        quizModelList.add(QuizModel("4","Matematicas","preguntas de Matematicas","15",listQuestionModelMatematicas));
        setupRecyclerView()
    }
}














