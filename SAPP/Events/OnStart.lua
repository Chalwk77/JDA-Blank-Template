-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

local function GetTag(Type, Name)
    local Tag = lookup_tag(Type, Name)
    return Tag ~= 0 and read_dword(Tag + 0xC) or nil
end

function Event:OnStart(script_load)

    self.ffa = (get_var(0, '$ffa') == "1")
    self.map = get_var(0, '$map')
    self.mode = get_var(0, '$mode')
    self.total = tonumber(get_var(0, '$pn'))
    self.falling = GetTag('jpt!', 'globals\\falling')
    self.distance = GetTag('jpt!', 'globals\\distance')
    self.first_blood = true

    self.players = {}
    self.players[0] = self:NewPlayer({
        id = 0,
        ip = 'localhost',
        name = '* SERVER *',
        hash = 'N/A',
        team = 'N/A'
    })

    if (not script_load) then
        self:Log(self:getEvent('Start'))
    end

    for i = 1, 16 do
        if player_present(i) then
            self:OnJoin(i)
        end
    end
end

register_callback(cb['EVENT_GAME_START'], 'OnStart')

return Event