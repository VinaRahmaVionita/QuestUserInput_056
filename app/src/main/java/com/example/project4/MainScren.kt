package com.example.project4

import android.renderscript.Sampler.Value
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MainScren(
    modifier: Modifier = Modifier
){
    var nama by rememberSaveable { mutableStateOf(" ") }
    var email by remember { mutableStateOf(" ") }
    var alamat by remember { mutableStateOf(" ") }
    var noHp by remember { mutableStateOf(" ") }
    var selectedGender by remember { mutableStateOf(" ") }

    val JenisKelamin = listOf("Laki - laki", "Perempuan")  //variable untuk menampung gender

    var namaUser by rememberSaveable { mutableStateOf(" ") }
    var emailUser by remember { mutableStateOf(" ") }
    var alamatUser by remember { mutableStateOf(" ") }
    var noHpUser by remember { mutableStateOf(" ") }
    var selectedGenderUser by remember { mutableStateOf(" ") }

    Column (Modifier.fillMaxSize()
        .padding(16.dp)
        ,horizontalAlignment = Alignment.CenterHorizontally
        ) {
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan Nama")},
            label = { Text("Nama")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Row() {
            JenisKelamin.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically) //agar sejajar dengan radio button
                { RadioButton(selected = selectedGender == item,
                    onClick = {
                        selectedGender = item
                    })
                    Text(item)
                }
            }

        }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan Email")},
            label = { Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat")},
            label = { Text("Alamat")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = noHp,
            onValueChange = {noHp = it},
            placeholder = { Text("Masukkan NoHP")},
            label = { Text("NoHp")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Button(onClick = {
            namaUser = nama
            selectedGenderUser = selectedGender
            emailUser = email
            alamatUser = alamat
            noHpUser = noHp
        }) {
            Text("Simpan")
        }

        Card(modifier.size(height = 300.dp, width = 300.dp)) {
            CardSection(judulParam = "Nama", isiParam = namaUser)
            CardSection(judulParam = "Jenis Kelamin", isiParam = selectedGenderUser)
            CardSection(judulParam = "Email", isiParam = emailUser)
            CardSection(judulParam = "Alamat", isiParam = alamatUser)
            CardSection(judulParam = "NoHp", isiParam = noHpUser)
        }
    }
}

@Composable
fun CardSection(judulParam:String, isiParam:String){

    Column (horizontalAlignment = Alignment.Start, modifier = Modifier.padding(10.dp))
    {
        Row( modifier = Modifier.fillMaxWidth()
            .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$isiParam",
                modifier = Modifier.weight(2f) )
        }
    }

}
