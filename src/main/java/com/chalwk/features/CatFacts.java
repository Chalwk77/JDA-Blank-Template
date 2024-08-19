/* Copyright (c) 2024, JDA-Blank-Template. Jericho Crosby <jericho.crosby227@gmail.com> */
package com.chalwk.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CatFacts {
    private static final List<String> facts;
    private static final Random random = new Random();
    private static final int CHANCE_PERCENT = 10; // 10% chance

    static {
        facts = new ArrayList<>();
        facts.add("Cats have a total of 18 toes: 5 on each front paw and 4 on each back paw.");
        facts.add("Cats can hear up to 4 times the frequency of humans.");
        facts.add("Did you know that cats can't taste sweetness? It's a purr-fect excuse to keep those sugary treats for yourself, dearie!");
        facts.add("A cat's whiskers are as long as their body is wide. Nature's tape measure, if you ask me!");
        facts.add("Did you know that a group of cats is called a \"clowder\"? I've got myself a clowder of furry friends!");
        facts.add("Cats only meow to communicate with humans, not other cats. Aren't we lucky to have such chatty companions?");
        facts.add("Did you know that cats have over 100 different vocalizations? They're quite the conversationalists!");
        facts.add("A cat can jump up to six times its length! It's a wonder they don't have wings.");
        facts.add("Did you know that a cat's heart beats twice as fast as a human's? I guess they have twice as much love to give!");
        facts.add("Cats are said to have nine lives. I'm not sure if that's true, but my kitties sure act like they do!");
        facts.add("A cat's nose is as unique as a human fingerprint - no two are the same! Purr-haps that's how they sniff out mischief.");
        facts.add("Did you know that a cat's purr can help heal their own bones and muscles? Now that's what I call a power nap!");
        facts.add("Cats sleep for about 70% of their lives. Ah, the life of a feline is truly a dream!");
        facts.add("Did you know that the first cat in space was a French feline named Felicette? Talk about a meow-t of this world adventure!");
        facts.add("A cat's tail contains nearly 10% of their bones. I guess that's one way to keep their balance, and our hearts!");
        facts.add("Did you know that cats have a dominant paw, just like humans have a dominant hand? Now, if only they could knit me a sweater!");
        facts.add("Cats can rotate their ears 180 degrees, so they can hear the sound of a treat bag from any direction!");
        facts.add("Did you know that a cat's brain is more similar to a human's than a dog's? I always knew my kitties were brilliant!");
        facts.add("A cat's sense of smell is 14 times stronger than a human's. No wonder they can smell a fishy treat from a mile away!");
        facts.add("Did you know that cats have a third eyelid called a nictitating membrane? It's like they're always ready for a surprise blink-and-you'll-miss-it moment!");
        facts.add("Cats can run up to 30 miles per hour - that's faster than Usain Bolt! I guess that explains why they're always zooming around the house.");
        facts.add("Did you know that cats can see in the dark, thanks to their amazing night vision? They're like little feline ninjas!");
        facts.add("A cat's collarbone is not connected to any other bone in their body. That explains how they manage to squeeze into the tightest spots!");
        facts.add("Did you know that a cat's fur can help regulate their body temperature? It's like a built-in fluffy thermostat!");
        facts.add("Cats have a special scent gland on their cheeks, which is why they rub their faces on us. They're marking us as their best friends - how adorable!");
        facts.add("Did you know that cats can predict earthquakes? Some say it's because they can sense changes in the Earth's magnetic field.");
        facts.add("A cat's tail can reveal their mood, so watch out for those tail signals!");
        facts.add("Did you know that cats have a heightened sense of touch? Their whiskers and paws are like little sensors, helping them navigate the world around them.");
        facts.add("Did you know that cats can be trained to use the toilet? Now that's what I call a proper potty-trained feline!");
        facts.add("A cat's purr is usually around 25 decibels, which is about as loud as a whisper. It's like a secret language between you and your kitty!");
        facts.add("Did you know that some cats have extra toes? These adorable felines are called polydactyl cats, and they're like little multi-toed wonders!");
        facts.add("Cats have a special scent organ in the roof of their mouth, which helps them 'taste' smells. No wonder they make that funny face when they sniff something new!");
        facts.add("Did you know that the richest cat in the world inherited $13 million? That's one lucky feline!");
        facts.add("A cat's claws grow in layers, like an onion. Remember to keep those scratching posts handy to help them shed those layers!");
        facts.add("Did you know that cats can drink seawater? Their kidneys can filter out the salt - how paw-some is that?");
        facts.add("Cats have a natural hunting instinct and can help control rodent populations. It's like having your very own feline exterminator!");
        facts.add("Did you know that cats have been domesticated for over 4,000 years? I guess they've been ruling our hearts for centuries!");
        facts.add("A cat's fur can change color with their body temperature. It's like a mood ring for kitties!");
        facts.add("Did you know that cats are believed to have been worshipped in ancient Egypt? I always knew they were divine creatures!");
        facts.add("Cats have an extra organ that allows them to taste scents in the air. Now, if only they could help me pick out my perfume!");
        facts.add("Did you know that some cats can open doors? They're like little feline magicians!");
        facts.add("A cat's sense of balance is so good that they can walk on narrow ledges and fences. It's like they're part acrobat, part ninja!");
        facts.add("Did you know that cats have a natural GPS? They can find their way back home from miles away - now that's some serious navigation skills!");
        facts.add("Cats have super-sensitive paw pads that can detect vibrations. They can feel your footsteps even before you enter the room!");
        facts.add("Did you know that cats can see up to 120 feet away? I guess that explains why they're always staring out the window!");
        facts.add("A cat's nose is just as unique as a human fingerprint. No two kitty noses are the same - how cute is that?");
    }

    public static String getRandomFact() {
        int randomIndex = random.nextInt(facts.size());
        return facts.get(randomIndex);
    }

    public List<String> getAllFacts() {
        return facts;
    }

    // create a method to return the chance:
    public static boolean shouldSendCatFact() {
        return random.nextInt(100) < CHANCE_PERCENT;
    }
}