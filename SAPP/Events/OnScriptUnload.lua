-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

function Event:OnUnload()
    self:Log(self:getEvent('ScriptUnload'))
end

return Event