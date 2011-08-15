/*
 * Copyright (c) 2010 Devoxx Schedule app - Andres Almiray. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of Effects - Andres Almiray nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 'AS IS'
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package devoxx

/**
 * @author Andres Almiray
 */
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
