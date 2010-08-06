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
class DevoxxController {
    def builder
    def model
    def view
    def devoxxService

    def onWindowShown = { window ->
        def loader = jxwithWorker(start: false) {
            onInit{}
            work {
                [catalogs: ['tracks', 'rooms', 'experiencelevels'],
                 speakers: null, presentations: null, schedule: null].each { type, values ->
                    def subject = values ?: [type]
                    subject.each { devoxxService."$it" }
                    publish type  
                }
            }
            onUpdate { chunks ->
                chunks.each { type ->
                    String category = Constants.TYPES[type].icon.category
                    String icon = Constants.TYPES[type].icon.name
                    model.loader[type] = builder.crystalIcon(size: 32, category: category, icon: icon)
                }
            }
            onDone {
                ['speakers', 'presentations', 'schedule'].each { type ->
                    app.models[type].update()
                }
                view.main.layout.next(view.main)
            }
        }

        // pause so that splash can be seen
        Thread.sleep 3000
        // display loader screen
        view.main.layout.next(view.main)
        // wait for transition to finish
        Thread.sleep 1500
        loader.execute()
    }
}
