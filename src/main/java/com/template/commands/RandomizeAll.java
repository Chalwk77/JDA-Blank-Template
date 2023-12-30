/* Copyright (c) 2023, PGR2-Bot. Jericho Crosby <jericho.crosby227@gmail.com> */
package com.template.commands;

import com.template.listeners.CommandInterface;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

import static com.template.Main.timeOfDay;
import static com.template.Main.weather;
import static com.template.util.Cars.carsMap;
import static com.template.util.Tracks.tracksMap;

public class RandomizeAll implements CommandInterface {

    private final String vehicleClassLabel = "Vehicle Class:";
    private final String vehicleLabel = "Vehicle: :race_car:";
    private final String trackLabel = "Track: \uD83C\uDFC1";

    @Override
    public String getName() {
        return "pgr2";
    }

    @Override
    public String getDescription() {
        return "Randomizes game settings for you.";
    }

    @Override
    public List<OptionData> getOptions() {

        List<OptionData> data = new ArrayList<>();
        OptionData options = new OptionData(OptionType.STRING, "options", "Generate a random vehicle class, vehicle, track, time of day, and weather").setRequired(true);

        options.addChoice("class", "class");
        options.addChoice("vehicle", "vehicle");
        options.addChoice("track", "track");
        options.addChoice("weather", "weather");
        options.addChoice("time", "time");
        options.addChoice("all", "all");

        data.add(options);
        return data;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        OptionMapping option = event.getOption("options");
        if (option == null) {
            randomizeAll(event);
            return;
        }
        switch (option.getAsString()) {
            case "class":
                randomizeVehicleClass(event);
                break;
            case "vehicle":
                randomizeVehicle(event);
                break;
            case "track":
                randomizeTrack(event);
                break;
            case "all":
                randomizeAll(event);
                break;
            case "time":
                randomizeTime(event);
                break;
            case "weather":
                randomizeWeather(event);
                break;
            default:
                randomizeAll(event);
                break;
        }
    }

    private void randomizeVehicleClass(SlashCommandInteractionEvent event) {
        ArrayList<String> vehicleClasses = new ArrayList<>(carsMap.keySet());
        String randomVehicleClass = vehicleClasses.get((int) (Math.random() * vehicleClasses.size()));
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("PGR2  |  RANDOM CLASS:");
        embed.setColor(0x00FF00);
        embed.addField(vehicleClassLabel, randomVehicleClass, false);
        event.replyEmbeds(embed.build()).queue();
    }

    private void randomizeVehicle(SlashCommandInteractionEvent event) {
        ArrayList<String> vehicleClasses = new ArrayList<>(carsMap.keySet());
        String randomVehicleClass = vehicleClasses.get((int) (Math.random() * vehicleClasses.size()));
        ArrayList vehicles = carsMap.get(randomVehicleClass);
        String randomVehicle = (String) vehicles.get((int) (Math.random() * vehicles.size()));

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("PGR2  |  RANDOM VEHICLE:");
        embed.setColor(0x00FF00);
        embed.addField(vehicleLabel, randomVehicle, false);
        event.replyEmbeds(embed.build()).queue();
    }

    private void randomizeTrack(SlashCommandInteractionEvent event) {
        ArrayList<String> cities = new ArrayList<>(tracksMap.keySet());
        String tracks = cities.get((int) (Math.random() * cities.size()));
        ArrayList track = tracksMap.get(tracks);
        String randomTrack = (String) track.get((int) (Math.random() * track.size()));
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("PGR2  |  RANDOM TRACK:");
        embed.setColor(0x00FF00);
        embed.addField(trackLabel, randomTrack + " (" + tracks + ")", false);
        event.replyEmbeds(embed.build()).queue();
    }

    private void randomizeTime(SlashCommandInteractionEvent event) {
        String randomTime = timeOfDay.get((int) (Math.random() * timeOfDay.size()));
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("PGR2  |  RANDOM TIME:");
        embed.setColor(0x00FF00);
        String timeLabel = "Time of Day:";
        embed.addField(timeLabel, randomTime, false);
        event.replyEmbeds(embed.build()).queue();
    }

    private void randomizeWeather(SlashCommandInteractionEvent event) {
        String randomWeather = weather.get((int) (Math.random() * weather.size()));
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("PGR2  |  RANDOM WEATHER:");
        embed.setColor(0x00FF00);
        String weatherLabel = "Weather:";
        embed.addField(weatherLabel, randomWeather, false);
        event.replyEmbeds(embed.build()).queue();
    }

    private void randomizeAll(SlashCommandInteractionEvent event) {

        ArrayList<String> vehicleClasses = new ArrayList<>(carsMap.keySet());
        String randomVehicleClass = vehicleClasses.get((int) (Math.random() * vehicleClasses.size()));
        ArrayList vehicles = carsMap.get(randomVehicleClass);
        String randomVehicle = (String) vehicles.get((int) (Math.random() * vehicles.size()));

        ArrayList<String> cities = new ArrayList<>(tracksMap.keySet());
        String tracks = cities.get((int) (Math.random() * cities.size()));
        ArrayList track = tracksMap.get(tracks);
        String randomTrack = (String) track.get((int) (Math.random() * track.size()));

        String randomTime = timeOfDay.get((int) (Math.random() * timeOfDay.size()));
        String randomWeather = weather.get((int) (Math.random() * weather.size()));

        if (tracks.equals("Paris") || tracks.equals("Long Beach") || randomTime.equals("Night :night_with_stars:")) {
            randomWeather = "Clear :sun_with_face:";
        }

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Randomized Settings:");
        embed.setColor(0x00FF00);
        embed.setDescription("Here are your randomized settings:");
        embed.addField(vehicleClassLabel, randomVehicleClass, false);
        embed.addField(vehicleLabel, randomVehicle, false);
        embed.addField(trackLabel, randomTrack + " (" + tracks + ")", false);
        String timeLabel = "Time of Day:";
        embed.addField(timeLabel, randomTime, false);
        String weatherLabel = "Weather:";
        embed.addField(weatherLabel, randomWeather, false);
        event.replyEmbeds(embed.build()).queue();
    }
}