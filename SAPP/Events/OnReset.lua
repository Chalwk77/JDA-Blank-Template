-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

function Event:OnReset()
    self:Log(self:getEvent('Reset'))
end

register_callback(cb['EVENT_MAP_RESET'], 'OnReset')

return Event