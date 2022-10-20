-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

function Event:OnQuit()
    self.total = self.total - 1
    self:Log(self:getEvent('Quit'))
    self = nil
end

register_callback(cb['EVENT_LEAVE'], 'OnQuit')

return Event