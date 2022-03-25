# Phrase-Counter

Having noticed some of my teachers having specific words or phrases repeating from time to time, rather often on some occasions, the idea for an app was born.

This application is created with the intent, of allowing people to add a phrase for a person

## Progress

### User Interface
- [ ] Home Page (Currently has a Basic one that needs to be redesigned)
- [x] Leaderboard
- [x] Add New Phrase
- [ ] Light Theme
- [ ] Dark Theme
- [ ] Custom Application Icon

### Functionality
- [x] Add a new Course, Person, and Phrase
- [x] View leaderboards over People and their Phrases
- [ ] Click on Leaderboard to access the specific Counter for that Phrase
- [x] Store things locally in SQLite Database


## Possible Additions

### Remote Storage

I have considered setting it up with a possibility to connect remotely to a Database, which would allow multiple users to see the Leaderboards over a set of phrases. Though I am wondering, how this would work in the case of multiple people keeping track of the same phrase, whether I would need to implement a mechanic, which would use the Median or Average of the most recent changes within a given timelimit.
