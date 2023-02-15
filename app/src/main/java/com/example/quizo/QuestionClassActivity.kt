package com.example.quizo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.quizo.databinding.ActivityQuestionClassBinding

class QuestionClassActivity : AppCompatActivity() {

    var Qindex: Int = 0
    var updateQuestion: Int = 1
    var givenanswer: String? = null
    private var defaultColor: ColorStateList? = null
    private val countDownInMilliSecond: Long = 30000
    private val countDownInterval: Long = 1000
    private var timeLeftMilliSeconds: Long = 0
    private var hasFinished = false

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

    lateinit var binding: ActivityQuestionClassBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionClassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent1 = intent
        subject = intent1.getStringExtra("subject")
        binding.topicTVid.text = "$subject"




        if (subject == "Java") {
            intialQuestion(JavaQuestion)
            nextquestionbtnclicked(binding.nextbtnid, JavaQuestion)
            binding.quedtionindextvid.text = "${updateQuestion}/${JavaQuestion.size}"


        } else if (subject == "Android") {
            intialQuestion(AndroidQuestion)
            nextquestionbtnclicked(binding.nextbtnid, AndroidQuestion)
            binding.quedtionindextvid.text = "${updateQuestion}/${AndroidQuestion.size}"

        } else if (subject == "Kotlin") {
            intialQuestion(KotlinQuestion)
            nextquestionbtnclicked(binding.nextbtnid, KotlinQuestion)
            binding.quedtionindextvid.text = "${updateQuestion}/${KotlinQuestion.size}"

        } else if (subject == "C Programming") {
            intialQuestion(CprogramingQuestion)
            nextquestionbtnclicked(binding.nextbtnid, CprogramingQuestion)
            binding.quedtionindextvid.text = "${updateQuestion}/${CprogramingQuestion.size}"

        } else if (subject == "HTML") {
            val intent = Intent(applicationContext, ErrorActivity::class.java)
            startActivity(intent)
        }


    }


    private fun nextquestionbtnclicked(nextbtnid: AppCompatButton, Quizlist: List<DataClass>) {
        nextbtnid.setOnClickListener {

            if (binding.radiogroupid.checkedRadioButtonId == -1) {
                Toast.makeText(applicationContext, "Please Select an Option", Toast.LENGTH_SHORT)
                    .show()

            } else {
                shownextQuestion(Quizlist)
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun shownextQuestion(Quizlist: List<DataClass>) {
        checkAnswer()
        binding.apply {
            if (updateQuestion < Quizlist.size) {
                updateQuestion++
                binding.quedtionindextvid.text = "${updateQuestion}/${Quizlist.size}"

            }


            if (Qindex <= Quizlist.size - 1) {
                var quiz = Quizlist[Qindex]
                binding.questionnameTVid.text = quiz.question
                option1id.text = quiz.option1
                option2id.text = quiz.option2
                option3id.text = quiz.option3
                option4id.text = quiz.option4

            } else {
                hasFinished = true

            }
            radiogroupid.clearCheck()

        }


    }

    private fun checkAnswer() {
        Qindex++
    }


    private fun intialQuestion(QuestionList: List<DataClass>) {
        val quiz = QuestionList[Qindex]
        binding.questionnameTVid.text = quiz.question

        binding.apply {
            option1id.text = quiz.option1
            option2id.text = quiz.option2
            option3id.text = quiz.option3
            option4id.text = quiz.option4
        }
    }


}

