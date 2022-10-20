-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

function Event:OnEnd()
    self:Log(self:getEvent('End'))
end

register_callback(cb['EVENT_GAME_END'], 'OnEnd')

return Event