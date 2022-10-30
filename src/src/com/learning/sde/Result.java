package com.learning.sde;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.net.*;
//import com.google.gson.Gson;


class Result {

    class Geo {
        private String lat;
        private String lng;
    }

    class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
    }

    class Company {
        private String name;
        private String basename;
    }

    class ResponseObject {
        private int id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String website;
        private Company company;
    }

    private static String getField(ResponseObject object, String fieldName) {
        String result;
        switch(fieldName) {
            case "name":
                return object.name;
            case "username":
                return object.username;
            case "email":
                return object.email;
            case "website":
                return object.website;
            case "address.street":
                if (object.address != null) {
                    return object.address.street;
                }
            case "address.suite":
                if (object.address != null) {
                    return object.address.suite;
                } else {
                    return "";
                }
            case "address.city":
                if (object.address != null) {
                    return object.address.city;
                } else {
                    return "";
                }
            case "address.zipcode":
                if (object.address != null) {
                    return object.address.zipcode;
                } else {
                    return "";
                }
            case "company.name":
                if (object.company != null) {
                    return object.company.name;
                } else {
                    return "";
                }
            case "company.basename":
                if (object.company != null) {
                    return object.company.basename;
                } else {
                    return "";
                }
            default:
                return "";
        }
    }

    /*
     * Complete the 'apiResponseParser' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY inputList
     *  2. INTEGER size
     */

    public static List<Integer> apiResponseParser(List<String> inputList, int size) {
        List<Integer> result = new ArrayList<>();
        try {
            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            // int responseStatus = connection.getResponseCode();
            // System.out.println("Response status code: " + responseStatus);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder buffer = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
            bufferedReader.close();
            connection.disconnect();

            String response = buffer.toString();

            System.out.println("Response: " + response);

//            Gson gson = new Gson();
//            ResponseObject[] responseObjects = gson.fromJson(response, ResponseObject[].class);
//            int numRecords = responseObjects.length;
//            System.out.println("Response object len: " + numRecords);
//            System.out.println("first object details: " + responseObjects[0].id + ", " + responseObjects[0].name);

//            for (int i = 0; i< numRecords; i++) {
//                if (inputList.get(1).equalsIgnoreCase("EQUALS")) {
//                    String field = getField(responseObjects[i], inputList.get(0));
//                    if (field.equals(inputList.get(2))) {
//                        result.add(responseObjects[i].id);
//                    }
//                }
//            }


        } catch (Exception ex) {
            System.out.println("Exception while making rest call: " + ex);
        }

        return result.size() != 0 ? result : Collections.singletonList(-1);

    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int inputListCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> inputList = IntStream.range(0, inputListCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int size = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.apiResponseParser(inputList, size);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
