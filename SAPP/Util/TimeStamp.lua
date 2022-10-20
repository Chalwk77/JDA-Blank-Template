-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Time = {}

function Time:getTimeStamp()

    local _, ms = math.modf(os.clock())
    if ms == 0 then
        ms = '000'
    else
        ms = tostring(ms):sub(3, 5)
    end

    return os.date(self.date_format, os.time()) .. ':' .. ms
end

return Time