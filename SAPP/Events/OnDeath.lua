-- Server Logger Bot.
-- Copyright (c) 2022, Jericho Crosby <jericho.crosby227@gmail.com>

local Event = {}

local function InVehicle(player)
    local dyn = get_dynamic_player(player)
    return (dyn ~= 0 and read_dword(dyn + 0x11C) ~= 0xFFFFFFFF) or false
end

function Event:OnDeath(killer, victim, metaID)

    killer = tonumber(killer)
    victim = tonumber(victim)

    local k = self:getPlayer(killer)
    local v = self:getPlayer(victim)

    if (v) then

        -- event_damage_application:
        if (metaID) then
            v.meta = metaID
            return true
        end

        v.victim = v.name
        if (k) then
            k.killer = k.name
        end

        -- event_die:
        local squashed = (killer == 0)
        local guardians = (killer == nil)
        local suicide = (killer == victim)
        local pvp = (k and killer ~= victim)
        local server = (killer == -1 and not v.switched)
        local fell = (v.meta == self.falling or v.meta == self.distance)
        local betrayal = (k and not self.ffa and (v.team == k.team and killer ~= victim))

        if (pvp and not betrayal) then

            if (self.first_blood) then
                self.first_blood = false
                k:Log(k:getEvent('first_blood'))
            end

            if (not player_alive(killer)) then
                k:Log(k:getEvent('killed_from_grave'))
                goto done
            elseif (InVehicle(killer)) then
                k:Log(k:getEvent('run_over'))
                goto done
            end
            k:Log(k:getEvent('pvp'))

        elseif (guardians) then
            v:Log(v:getEvent('guardians'))
        elseif (suicide) then
            v:Log(v:getEvent('suicide'))
        elseif (betrayal) then
            v:Log(v:getEvent('betrayal'))
        elseif (squashed) then
            v:Log(v:getEvent('squashed'))
        elseif (fell) then
            v:Log(v:getEvent('fell'))
        elseif (server) then
            v:Log(v:getEvent('server'))
        elseif (not v.switched) then
            v:Log(v:getEvent('unknown'))
        end

        :: done ::
    end
end

register_callback(cb['EVENT_DIE'], 'OnDeath')
register_callback(cb['EVENT_DAMAGE_APPLICATION'], 'OnDeath')

return Event