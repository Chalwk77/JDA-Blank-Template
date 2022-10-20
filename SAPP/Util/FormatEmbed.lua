-- Server Logger Bot.
-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local StringBuilder = {}

function StringBuilder:formatString(str)

    local placeholders = {

        -- player vars:
        ['$ip'] = self.ip,
        ['$id'] = self.id,
        ['$lvl'] = self.lvl,
        ['$name'] = self.name,
        ['$hash'] = self.hash,
        ['$team'] = self.team,
        ['$pirated'] = self.pirated,

        -- server vars:
        ['$cmd'] = self.command,
        ['$map'] = self.map,
        ['$mode'] = self.mode,
        ['$total'] = self.total,
        ['$victim'] = self.victim,
        ['$killer'] = self.killer,
        ['$msg'] = self.chat_message,
        ['$command_type'] = self.command_type,
        ['$message_type'] = self.message_type
    }

    for k, v in pairs(placeholders) do
        str = str:gsub(k, v)
    end

    return str
end

function StringBuilder:Build(embed)

    -- Format the above embed:
    local title = embed.title              -- String
    local description = embed.description  -- String
    local color = embed.color              -- Integer
    local fields = embed.fields            -- Array of String and boolean.
    local footer = embed.footer            -- String or Array of Strings.
    local thumbnail = embed.thumbnail      -- String
    local image = embed.image              -- String
    local author = embed.author            -- String

    -- Format the title:
    if (title) then
        title = self:formatString(title)
    end

    -- Format the description:
    if (description) then
        description = self:formatString(description)
    end

    -- Format the fields:
    if (fields) then
        for i = 1, #fields do
            local field = fields[i]
            local name = field.name
            local value = field.value
            local inline = field.inline
            if (name) then
                name = self:formatString(name)
            end
            if (value) then
                value = self:formatString(value)
            end
            fields[i] = { name = name, value = value, inline = inline }
        end
    end

    -- Format the footer:
    if (footer) then
        local text = footer.text
        local icon_url = footer.icon_url
        if (text) then
            text = self:formatString(text)
        end
        if (icon_url) then
            icon_url = self:formatString(icon_url)
        end
        footer = { text = text, icon_url = icon_url }
    end

    -- Format the thumbnail:
    if (thumbnail) then
        local url = thumbnail.url
        if (url) then
            url = self:formatString(url)
        end
        thumbnail = { url = url }
    end

    -- Format the image:
    if (image) then
        local url = image.url
        if (url) then
            url = self:formatString(url)
        end
        image = { url = url }
    end

    -- Format the author:
    if (author) then
        local name = author.name
        local url = author.url
        local icon_url = author.icon_url
        if (name) then
            name = self:formatString(name)
        end
        if (url) then
            url = self:formatString(url)
        end
        if (icon_url) then
            icon_url = self:formatString(icon_url)
        end
        author = { name = name, url = url, icon_url = icon_url }
    end

    return {
        title = title,
        description = description,
        color = color,
        fields = fields,
        footer = footer,
        thumbnail = thumbnail,
        image = image,
        author = author
    }
end

return StringBuilder