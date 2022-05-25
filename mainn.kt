
import java.lang.Exception
import java.util.Scanner
var scan=Scanner(System.`in`)
var theatreArray =ArrayList<Theatre> ()

var id:Int=100

fun main() {
   operation()
}



fun operation(){
    println("Enter choice")
    println("1 add\t 2 remove\t 3 update\t 4 display\t 5 exit")
    try {

        var ops:Int = Scanner(System.`in`).nextInt()
        if(ops<=5) {

            when (ops) {
                1 -> add()
                2 -> remove()
                3 -> update()
                4 -> display()
                5 -> exit()


            }
        }
        else{
            println("Invalid choice")
            operation()
        }

    }catch (ex: Exception){
        println("Invalid choice")
        operation()
    }

}



fun add(){


    println("Enter Theatre name")
    var name:String=scan.next()


    println("Enter Theatre location")
    var location:String=scan.next()


    var obj=Theatre(theatre_id = id, theatre_name = name, theatre_location = location)



      if(theatreArray.isEmpty()){
          theatreArray.add(obj)
          id+=100
      }
    else {
          for (i in theatreArray) {

              if (name.equals(i.theatre_name)&&location.equals(i.theatre_location)) {
                  println("Theatre repeated")
              } else {
                  theatreArray.add(obj)
                  id+=100
                  break
              }
          }
      }





    operation()

}



fun remove(){

    println(" Enter Theatre name")
    var remove_theatre:String=scan.next()


    for(i in theatreArray.indices) {

        if (remove_theatre.equals(theatreArray[i].theatre_name) ) {
            theatreArray.remove(theatreArray[i])
        }
        else{
            println("Theatre not found")
        }
    }
    operation()
}



fun display(){
    println("Theatre ID\t Theatre Name\t Theatre Location")
    for(i in theatreArray){
        println("\t${i.theatre_id}\t\t\t ${i.theatre_name}\t\t\t${i.theatre_location}")
    }

    operation()
}



fun update(){

    println("Enter Theatre Id")

    var name:Int=scan.nextInt()

    for(i in theatreArray.indices){

        if(name==theatreArray[i].theatre_id){
            var obj:Theatre=theatreArray[i]

            println(" 1 name \t 2 location")

            var calc=scan.nextInt()

            when(calc){

                1 -> obj.theatre_name=update_name()
                2 -> obj.theatre_location=update_location()
            }

            theatreArray.set(i,obj)
            println("Updated")
        }
        else{
            println("Unmatched Theatre Id")
            update()
        }

    }
operation()

}



/*fun update_id():Int{
    println("Enter new id")
    var i:Int=scan.nextInt()
    return i
}*/


fun update_name():String{
    println("Enter new name")
    var i:String=scan.next()
    return i
}


fun update_location():String{
    println("Enter new location")
    var i:String=scan.next()
    return i
}



fun exit(){
    println("completed")
}