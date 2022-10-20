-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local EventParser = {}

function EventParser:getEvent(event)

    event = self.events[event]

    local embed = event.embed

    embed = self:Build(embed)
    local enabled = event.enabled
    local channel = event.channel

    return { embed, enabled, channel }
end

return EventParser