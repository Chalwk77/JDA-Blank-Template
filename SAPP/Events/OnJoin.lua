-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

function Event:NewPlayer(o)

    setmetatable(o, self)
    self.__index = self

    o.total = tonumber(get_var(0, '$pn'))
    o.meta = 0
    o.switched = false
    o.lvl = tonumber(get_var(o.id, '$lvl'))
    o.pirated = (self[o.hash] and 'YES' or 'NO')

    if (o.id > 0) then
        o:Log(o:getEvent('Join'))
    end

    return o
end

function Event:OnJoin(player)
    self.players[player] = self:NewPlayer({
        id = player,
        ip = get_var(player, '$ip'),
        name = get_var(player, '$name'),
        hash = get_var(player, '$hash'),
        team = (not self.ffa and get_var(player, '$team') or 'FFA')
    })
end

register_callback(cb['EVENT_JOIN'], 'OnJoin')

return Event