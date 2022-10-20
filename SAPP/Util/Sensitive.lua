-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Data = {}

function Data:Sensitive(s)
    local t = self.sensitive_content
    for i = 1, #t do
        if (s:find(t[i])) then
            return true
        end
    end
    return false
end

return Data