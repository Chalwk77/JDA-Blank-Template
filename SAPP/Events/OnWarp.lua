-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

function Event:OnWarp()
    self:Log(self:getEvent('Warp'))
end

register_callback(cb['EVENT_WARP'], 'OnWarp')

return Event