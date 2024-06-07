/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica.demo.service;

import com.example.practica.demo.dto.ConsumeIdAndStringDto;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class ApiWebServiceImpl implements ApiWebService {

    @Override
    public List<ConsumeIdAndStringDto> getListaApi(String response) {
        List<ConsumeIdAndStringDto> listaConsumeIdAndStringDto = new ArrayList<>();
        ConsumeIdAndStringDto consumeIdAndStringDto;

        JsonArray jsonArray = JsonParser.parseString(response).getAsJsonArray();
        JsonObject jsonObject;
        for (JsonElement jsonElement : jsonArray) {
            consumeIdAndStringDto  = new ConsumeIdAndStringDto();
            jsonObject = jsonElement.getAsJsonObject();
            String stringId = jsonObject.get("_id").getAsString();
            String stringUser = jsonObject.get("user").getAsString();
            
            consumeIdAndStringDto.setId(stringId);
            consumeIdAndStringDto.setNombre(stringUser);
            listaConsumeIdAndStringDto.add(consumeIdAndStringDto);
        }
        

        return listaConsumeIdAndStringDto;

    }

}
