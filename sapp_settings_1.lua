return {

    --
    -- Name of the log file for this server:
    --
    file = 'Server Logger Bot/Logs/logs_1.json',

    --
    -- Timestamp format:
    -- For help with date & time format, refer to this page: www.lua.org/pil/22.1.html
    --
    date_format = '!%a, %d %b %Y %H:%M:%S',

    --
    -- CUSTOMIZABLE EVENTS MESSAGES:
    -- You can enable or disable individual events.
    --
    events = {

        -- EXAMPLE EVENT CONFIGURATION:
        ['EXAMPLE'] = {

            -- Sets whether this event should be logged:
            enabled = true,

            -- Sets the channel id that event embed message will be posted in:
            channel = "1032411616001671318",

            -- Event embed message to be sent to the discord channel:
            embed = {
                title = '[SCRIPT LOAD]',
                description = 'Server Logger Script has been loaded',
                color = "0x00FF00",
                fields = {
                    { name = 'Field 1', value = 'Field 1 Value', inline = true },
                    { name = 'Field 2', value = 'Field 2 Value', inline = true },
                    { name = 'Field 3', value = 'Field 3 Value', inline = true },
                    -- repeat the structure to add more fields.
                },
                footer = {
                    text = 'Footer Text',
                    icon_url = 'https://i.imgur.com/1J2Q9Za.png',
                },
                thumbnail = {
                    url = 'https://i.imgur.com/1J2Q9Za.png',
                },
                image = {
                    url = 'https://i.imgur.com/1J2Q9Za.png',
                },
                author = {
                    name = 'Author Name',
                    url = 'https://i.imgur.com/1J2Q9Za.png',
                    icon_url = 'https://i.imgur.com/1J2Q9Za.png',
                },
            }
        },

        -- Script load/unload:
        ['ScriptLoad'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[SCRIPT LOAD]',
                description = 'Server Logger Script has been loaded',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                },
            }
        },
        ['ScriptReload'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[SCRIPT RELOAD]',
                description = 'Server Logger Script has been reloaded',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['ScriptUnload'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[SCRIPT UNLOAD]',
                description = 'Server Logger Script has been unloaded',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },

        -- Start/Finish
        ['Start'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[NEW GAME]',
                description = 'A new game has started.',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                },
                fields = {
                    { name = 'Map', value = '$map', inline = true },
                    { name = 'Mode', value = '$mode', inline = true },
                    { name = 'Time Limit:', value = '(not yet implemented)', inline = true },
                }
            }
        },
        ['End'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[GAME OVER]',
                description = 'Game Ended - Showing Post Game Carnage report',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },

        -- Join/Quit
        ['Join'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[JOIN]',
                description = '$name ID: [$id] IP: [$ip] Hash: [$hash] Pirated: [$pirated] Total Players: [$total/16]',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['Quit'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[QUIT]',
                description = '$name ID: [$id] IP: [$ip] Hash: [$hash] Pirated: [$pirated] Total Players: [$total/16]',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },

        -- Generic:
        ['Spawn'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[SPAWN]',
                description = '$name has spawned',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['Warp'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[WARP]',
                description = '$name is warping',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['Login'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[LOGIN]',
                description = '$name has logged in. Admin Level: [$lvl]',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['Reset'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[MAP RESET]',
                description = 'The map has been reset',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['Switch'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[TEAM SWITCH]',
                description = '$name switched teams. New team: [$team]',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },

        -- Command/Chat
        ['Command'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[COMMAND]',
                description = '[COMMAND] $name: /$cmd [Type: $command_type] Admin Level: [$lvl]',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['Chat'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[CHAT MESSAGE]',
                description = '[MESSAGE] $name: $msg [Type: $message_type]',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },

        -- death:
        ['unknown'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim died',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['pvp'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim was killed by $killer',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['suicide'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim committed suicide',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['fell'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim fell and broke their leg',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['server'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim was killed by the server',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['run_over'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim was run over by $killer',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['betrayal'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim was betrayed by $killer',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['squashed'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim squashed by a vehicle',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['first_blood'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim got first blood on $killer',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['guardians'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim and $killer were killed by the guardians',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
        ['killed_from_grave'] = {
            channel = "1032411616001671318",
            enabled = true,
            embed = {
                title = '[DEATH]',
                description = '$victim was killed from the grave by $killer',
                color = "0x00FF00",
                footer = {
                    text = '!%a, %d %b %Y %H:%M:%S',
                }
            }
        },
    },

    --
    -- Messages and commands containing these keywords will not be logged:
    --
    sensitive_content = {
        'login',
        'admin_add',
        'change_password',
        'admin_change_pw',
        'admin_add_manually',
    }
}