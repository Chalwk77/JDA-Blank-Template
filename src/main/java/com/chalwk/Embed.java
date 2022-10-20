package com.chalwk;

import com.chalwk.Utilities.GettersAndSetters;
import net.dv8tion.jda.api.EmbedBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;

public class Embed {

    public EmbedBuilder newEmbed(Object embedObject) {

        GettersAndSetters settings = new GettersAndSetters(embedObject);
        EmbedBuilder embed = new EmbedBuilder();

        String title = settings.getTitle();
        String desc = settings.getDescription();
        String color = settings.getColor();
        String image = settings.getImage();
        String footer = settings.getFooter();

        JSONArray fields = settings.getFields();

        if (title != null) {
            embed.setTitle(title);
        }
        if (desc != null) {
            embed.setDescription(desc);
        }
        if (color != null) {
            embed.setColor(Color.decode(color));
        }
        if (image != null) {
            embed.setImage(image);
        }
        if (footer != null) {
            embed.setFooter(footer);
        }
        if (fields != null) {
            fields.forEach(fieldObject -> {
                JSONObject obj = (JSONObject) fieldObject;
                String name = obj.getString("name");
                String value = obj.getString("value");
                boolean inline = obj.getBoolean("inline");
                embed.addField(name, value, inline);
            });
        }

        return embed;
    }
}
