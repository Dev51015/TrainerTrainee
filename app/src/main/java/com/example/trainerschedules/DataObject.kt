package com.example.trainerschedules

object DataObject {

    var listData = mutableListOf<Client>()

    fun setData(
        name: String,
        priority: String,
                /*age: Int,
                height: Double,
                weight: Double,
                fatPercent: Double,
                musclePercent: Double*/)
    {
        listData.add(Client(name,priority))
    }

    fun getAllData():List<Client>
    {
        return listData
    }

    fun getData(pos: Int): Client {
        return listData[pos]
    }

    fun updateData(pos:Int,name:String)
    {
        listData[pos].name=name
    }

    fun deleteData(pos: Int): Client{
        return listData.removeAt(pos)
    }

    fun deleteAll(){
        listData.clear()
    }

}