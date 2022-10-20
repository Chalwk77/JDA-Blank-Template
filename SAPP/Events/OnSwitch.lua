-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

function Event:OnSwitch()
    self.switched = true
    self.team = get_var(self.id, '$team')
    self:Log(self:getEvent('Switch'))
end

register_callback(cb['EVENT_TEAM_SWITCH'], 'OnSwitch')

return Event