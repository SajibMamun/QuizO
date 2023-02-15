package com.example.quizo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.quizo.databinding.ActivityQuestionClassBinding

class QuestionClassActivity : AppCompatActivity() {

    var Qindex: Int = 0
    var givenanswer: String? = null

    var totalmarks: Int = 0
    private val AndroidQuestion = listOf<DataClass>(
        DataClass(
            "Android is ",
            "an operating system",
            "a web browser",
            "a web server",
            "None of the above",
            "an operating system",
            2
        ), DataClass(
            "Under which of the following Android is licensed?",
            "OSS",
            "Sourceforge",
            "Apache/MIT",
            "None of the above",
            "Apache/MIT",
            2
        ), DataClass(
            "For which of the following Android is mainly developed?",
            "Servers",
            "Desktops",
            "Laptops",
            "Mobile devices",
            "Mobile devices",
            2
        ), DataClass(
            "Which of the following virtual machine is used by the Android operating system?",
            "JVM",
            "Dalvik virtual machine",
            "Simple virtual machine",
            "None of the above",
            "Dalvik virtual machine",
            4
        )
    )


    private val JavaQuestion = listOf<DataClass>(
        DataClass(
            "Number of primitive data types in Java are?", "6", "7", "8", "9", "8", 1
        ),

        DataClass(
            "What is the size of float and double in java?",
            "32 & 64",
            "32 & 32",
            "64 & 64",
            "64 & 32",
            "32 & 64",
            2
        ), DataClass(
            "Which of the following is not a Java features?",
            "Dynamic",
            "Architecture Neutral",
            "Use of pointers",
            "Object-oriented",
            "Use of pointers",
            4
        ),

        DataClass(
            "The \\u0021 article referred to as a",
            "Unicode escape sequence",
            "Octal escape",
            "Hexadecimal",
            "Line feed",
            "nicode escape sequence",
            1
        ),

        DataClass(
            "_____ is used to find and fix bugs in the Java programs.",
            "JVM",
            "JRE",
            "JDK",
            "JDB",
            "JDB",
            1
        ),

        DataClass(
            "What is the return type of the hashCode() method in the Object class?",
            "Object",
            "int",
            "long",
            "void",
            "int",
            1
        )
    )


    private val KotlinQuestion = listOf<DataClass>(
        DataClass(
            "Kotlin was developed by?", "IBM", "NetBeans", "JetBrains", "Oracle", "JetBrains", 5
        ), DataClass(
            "___feature allows removing the risk of occurrence of NullPointerException in real time.",
            "Null Risk",
            "Null Safety",
            "Null Pointer",
            "All of the above",
            "Null Safety",
            5
        )
    )


    private val CprogramingQuestion = listOf<DataClass>(
        DataClass(
            "Who is the father of C language?",
            "Steve Jobs",
            "James Gosling",
            "Dennis Ritchie",
            "Rasmus Lerdorf",
            "Dennis Ritchie",
            2
        ),
        DataClass(
            "Which of the following is not a valid C variable name?",
            "int number;",
            "float rate;",
            "int variable_count;",
            "int $'main;",
            "int \$'main;",
            2
        ),
        DataClass(
            "All keywords in C are in __",
            "LowerCase letters",
            "UpperCase letters",
            "CamelCase letters",
            "None of the mentioned",
            "LowerCase letters",
            6
        ),
    )


    var subject: String? = null

    lateinit var binding1: ActivityQuestionClassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityQuestionClassBinding.inflate(layoutInflater)
        setContentView(binding1.root)

        var intent1 = intent
        subject = intent1.getStringExtra("subject")
        binding1.topicTVid.text = "$subject"




        if (subject == "Java") {
            intialQuestion(JavaQuestion)

        } else if (subject == "Android") {
            intialQuestion(AndroidQuestion)

        } else if (subject == "Kotlin") {
            intialQuestion(KotlinQuestion)

        } else if (subject == "C Programming") {
            intialQuestion(CprogramingQuestion)

        } else if (subject == "HTML") {
            val intent = Intent(applicationContext, ErrorActivity::class.java)
            startActivity(intent)
        }


    }

    private fun intialQuestion(QuestionList: List<DataClass>) {
        val quiz=QuestionList[Qindex]
        binding1.questionnameTVid.text=quiz.question

        binding1.apply {
            option1id.text=quiz.option1
            option2id.text=quiz.option2
            option3id.text=quiz.option3
            option4id.text=quiz.option4
        }


    }

}

