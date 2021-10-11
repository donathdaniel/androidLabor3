import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val question : MutableList<Question> = mutableListOf()
    val quizController = QuizController(question)
    quizController.doQuiz()
}

data class Question(var answers : MutableList<String>, val text : String)

class QuizController(var questions: MutableList<Question>){

    init {
        readFileLineByLineUsingForEachLine("src/main/resources/questions.txt")
    }
    fun readFileLineByLineUsingForEachLine(fileName: String) {
        var text = ""
        var answers: MutableList<String> = mutableListOf()

        File(fileName).readLines().forEachIndexed { index, word ->
            if (index % 5 == 0) {
                text = word; answers = mutableListOf()
            } else if (index % 5 == 4) {
                answers.add(word); questions.add(Question(answers, text))
            } else {
                answers.add(word)
            }
        }
    }

    fun randomizeQuestions(){
        questions.shuffle()
    }

    fun doQuiz(){
        randomizeQuestions()

        println("Quiz starting!\n")
        var finalPoints = 0

        questions.forEachIndexed { index, question ->
            println("${ question.text }\n")

            val correctAns = question.answers[0]
            val shuffledAns = question.answers.shuffled()

            shuffledAns.forEachIndexed { ind, s -> println("${ind+1}. $s") }
            print("Give me the number of the correct answer: ")
            val read = Scanner(System.`in`)
            var number = read.nextInt()

            while(number < 1 ||number > 4){
                println("Wrong answe, try again!")
                number = read.nextInt()
            }
            val answer = shuffledAns[number-1]
            if(answer == correctAns){
                println("It's the correct one!\n")
                finalPoints++
            }
            else{
                println("Wrong!\n")
            }
        }
        println("Your final points: $finalPoints")
    }
}
