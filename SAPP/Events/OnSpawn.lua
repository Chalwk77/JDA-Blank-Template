-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

function Event:OnSpawn()
    self.meta = 0
    self.switched = nil
    self:Log(self:getEvent('Spawn'))
end

register_callback(cb['EVENT_SPAWN'], 'OnSpawn')

return Event