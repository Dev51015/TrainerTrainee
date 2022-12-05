package com.example.trainerschedules

object DataObject {

    private var listData = mutableListOf<Client>()

    fun setData(
        name: String,
        priority: String,
        goal: String,
        age: String,
        height: String,
        heightUnit: String,
        weight: String,
        weightUnit: String,
        fatPercent: String,
        musclePercent: String,
        )
    {
        listData.add(Client(name,
            priority,
            goal,
            age,
            height,
            heightUnit,
            weight,
            weightUnit,
            fatPercent,
            musclePercent))
    }

    fun getAllData():List<Client>
    {
        return listData
    }

    fun getData(pos: Int): Client {
        return listData[pos]
    }

    fun updateData(pos:Int,
                   name:String,
                   priority: String,
                   goal: String,
                   age : String,
                   height: String,
                   heightUnit: String,
                   weight: String,
                   weightUnit: String,
                   fatPercent: String,
                   musclePercent: String
                   )
    {
        listData[pos].name=name
        listData[pos].priority=priority
        listData[pos].goal=goal
        listData[pos].age=age
        listData[pos].height=height
        listData[pos].heightUnit=heightUnit
        listData[pos].weight=weight
        listData[pos].weightUnit=weightUnit
        listData[pos].fatPercent=fatPercent
        listData[pos].musclePercent=musclePercent
    }

    fun deleteData(pos: Int): Client{
        return listData.removeAt(pos)
    }

    fun deleteAll(){
        listData.clear()
    }

}