-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

function Event:OnCommand(command, env)

    if (command == '' or self:Sensitive(command)) then
        return false
    end

    self.command = command
    self.command_type = (env == 0 and 'CONSOLE' or env == 1 and 'RCON' or env == 2 and 'CHAT')
    self.lvl = tonumber(get_var(self.id, '$lvl')) -- just in case

    self:Log(self:getEvent('Command'))
end

register_callback(cb['EVENT_COMMAND'], 'OnCommand')

return Event