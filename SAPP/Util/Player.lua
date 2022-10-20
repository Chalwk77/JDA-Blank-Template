-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Player = {}

function Player:getPlayer(player)
    return self.players[player]
end

return Player