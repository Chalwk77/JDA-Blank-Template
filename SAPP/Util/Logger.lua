-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Logger = {}

function Logger:Log(event)

    local embed = event[1]
    local enabled = event[2]
    local channel = event[3]

    if (enabled) then

        self.logs[#self.logs + 1] = { embed, false, channel }
        --self.logs[self:getTimeStamp()] = { embed, false, channel }

        self:WriteFile(self.logs)
    end
end

return Logger