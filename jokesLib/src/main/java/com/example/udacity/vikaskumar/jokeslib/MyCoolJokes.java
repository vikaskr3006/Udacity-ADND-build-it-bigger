package com.example.udacity.vikaskumar.jokeslib;

public class MyCoolJokes {

    private static String[] jokes = {
            "What’s the best thing about Switzerland?\n\nI don’t know, but the flag is a big plus.",
            "I dreamed I was forced to eat a giant marshmallow. When I woke up, my pillow was gone.",
            "Can a kangaroo jump higher than a house?\n\nOf course, a house doesn't jump at all",
            "Hear about the new restaurant called Karma?\n\nThere’s no menu: You get what you deserve.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away",
            "My relationship is like an iPad. I don't have an iPad.",
            "He who wakes up early, yawns all day long.",
            "Did you hear about the actor who fell through the floorboards?\n\nHe was just going through a stage.",
            "My relationship is like an iPad. I don't have an iPad.",
            "Why don’t scientists trust atoms?\n\nBecause they make up everything.",
            "Of course you're not fat. Just grab a couple of chairs and come sit with us.",
            "What did 0 say to 8?\n\nHey, nice belt!",
            "What do you call a parade of rabbits hopping backwards?\n\nA receding hare-line.",
            "I managed to lose my rifle when I was in the army. I had to pay $855 to cover the loss.\n\n" +
                    "I’m starting to understand why a Navy captain always goes down with his ship.",
            "What is invisible and smells of worms?\n" + "-\n" + "A bird’s fart.",
            "I can’t believe I forgot to go to the gym today. That’s 7 years in a row now.",
            "Why haven’t you ever seen any elephants hiding up trees? Because they’re really, really good at it.",
            "Why did the physics teacher break up with the biology teacher? There was no chemistry.",
            "I forgot my cell phone when I went to the toilet yesterday. We have 245 tiles.",
            "What’s the different between a cat and a comma?\n\n" +
                    "A cat has claws at the end of paws; A comma is a pause at the end of a clause."
    };

    private MyCoolJokes(){}

    public static String getRandomJoke(){
        return jokes[(int) (Math.random() * (jokes.length-1))];
    }
}
