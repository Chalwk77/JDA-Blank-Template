-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

local function IsCommand(s)
    return (s:sub(1, 1) == '/' or s:sub(1, 1) == '\\')
end

function Event:OnChat(message, type)

    if (message == '' or IsCommand(message) or self:Sensitive(message)) then
        return false
    end

    self.chat_message = message
    self.message_type = (type == 0 and 'GLOBAL' or type == 1 and 'TEAM' or type == 2 and 'VEHICLE')

    self:Log(self:getEvent('Chat'))
end

register_callback(cb['EVENT_CHAT'], 'OnChat')

return Event