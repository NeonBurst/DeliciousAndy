package com.example.deliciousandy.utility

import android.content.Context
import com.example.deliciousandy.data.models.AppData
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class ConverterJSON {

    fun convertRecipeJSON(data: AppData): String {
        val gson = Gson()
        return gson.toJson(data)
    }

    fun saveJsonToFile(jsonData: String, fileName: String, context: Context) {
        try {
            val file = File(context.filesDir, fileName)
            val fos = FileOutputStream(file)
            val osw = OutputStreamWriter(fos)
            osw.write(jsonData)
            osw.flush()
            osw.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun loadJsonFromFile(fileName: String, context: Context): String? {
        try {
            val file = File(context.filesDir, fileName)
            val fis = FileInputStream(file)
            val isr = InputStreamReader(fis)
            val br = BufferedReader(isr)
            val sb = StringBuilder()
            var line: String?
            while (br.readLine().also { line = it } != null) {
                sb.append(line)
            }
            br.close()
            return sb.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun convertJsonToUserData(jsonData: String): AppData {
        val gson = Gson()
        return gson.fromJson(jsonData, AppData::class.java)
    }

}