package com.treloc.sesizari.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.treloc.sesizari.dto.SesizareDTO;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class PrimarieApi {
    public List<SesizareDTO> get() {
        return getSesizari(null);
    }

    private List<SesizareDTO> getSesizari(String date) {
        date = (date == null) ? "03/12/2020" : date;
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = null;
        try {
            response = Unirest.post("https://report.e-primariaclujnapoca.ro/IncidentRP.aspx")
                    .header("origin", "https://mycluj.e-primariaclujnapoca.ro")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .field("categorycodelist", "")
                    .field("state", "A")
                    .field("incidentfromdate", date)
                    .field("incidenttodate", date)
                    .field("incidentno", "")
                    .field("calltype", "P")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<Collection<SesizareDTO>>() {
        }.getType();
        String value = response.getBody();
        value = value.replaceAll("\\[", "");
        value = value.replaceAll("\\]", "");
        value = "[" + value + "]";
        Gson gson = new Gson();
        List<SesizareDTO> result = gson.fromJson(value, listType);
        return result;
    }
}
