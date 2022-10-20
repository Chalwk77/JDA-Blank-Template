-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

function Event:OnLogin()
    self.lvl = tonumber(get_var(self.id, '$lvl'))
    self:Log(self:getEvent('Login'))
end

register_callback(cb['EVENT_LOGIN'], 'OnLogin')

return Event