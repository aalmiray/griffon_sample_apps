package devoxx

class DevoxxService {
    final String devoxx2010 = "1"

    final List experiencelevels = []
    final List tracks = []
    final Map rooms = [:]
    final Map speakers = [:]
    final Map presentations = [:]
    final List presentationtypes = []
    final List schedule = []

    List getExperiencelevels() {
        if(!experiencelevels) {
            experiencelevels.addAll(fetchCatalog('experiencelevels'))
        }
        experiencelevels
    }

    List getPresentationtypes() {
        if(!presentationtypes) {
            getPresentations()
        }
        presentationtypes
    }

    List getTracks() {
        if(!tracks) {
            tracks.addAll(fetchCatalog('tracks'))
        }
        tracks
    }

    Map getRooms() {
        if(!rooms) {
            rooms.putAll(fetchMapCatalog('schedule/rooms'))
        }
        rooms
    }

    Map getSpeakers() {
        if(!speakers) {
            speakers.putAll(fetchMapCatalog('speakers'))
        }
        speakers
    }

    Map getPresentations() {
        if(!presentations) {
            presentations.putAll(fetchMapCatalog('presentations'))
            presentationtypes.addAll(presentations.values()*.track.unique())
        }
        presentations
    }

    List getSchedule() {
        if(!schedule) {
            for(i in 1..5) {
                Map day = fetchMapCatalog('schedule/day/'+i)
                schedule << day
            }
        }
        schedule
    }

    private List fetchCatalog(String catalog) {
        rest {
            def response = get(path: devoxx2010 + '/' + catalog)
            response.data.collect([]) { it.Name } 
        }
    }

    private Map fetchMapCatalog(String catalog) {
        rest {
            def response = get(path: devoxx2010 + '/' + catalog)
            response.data.inject([:]) { m, e -> m[e.id] = e; m } 
        }
    }

    private rest(Closure cls) {
        withRest(id: 'devoxx', uri: 'http://cfp.devoxx.com/rest/v1/events/', cls)
    }
}
